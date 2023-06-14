import java.util.ArrayList;

import com.zeroc.Ice.Current;

import servicios.AlarmaServicePrx;
import servicios.BrokerService;
import servicios.Moneda;
import servicios.ServerRecieveAlarmServicePrx;



public class BrokerI implements BrokerService {

  /* Servidores Centrales */
  private ArrayList<ServerRecieveAlarmServicePrx> servers;
  private int currentServerIndex;

  public BrokerI() {
    servers = new ArrayList<ServerRecieveAlarmServicePrx>();
    currentServerIndex = 0;
  }
  // Función para localizar un servidor central disponible
  private ServerRecieveAlarmServicePrx locateServer() {

    if (servers.size() == 0) return null;
    
    ServerRecieveAlarmServicePrx selectedServer = servers.get(currentServerIndex);
    currentServerIndex = (currentServerIndex + 1) % servers.size();
    return selectedServer;
  }

  @Override
  public void registerServer(ServerRecieveAlarmServicePrx serverToRegister, Current current) {
    servers.add(serverToRegister);
    System.out.println("Server registrado: " + serverToRegister.toString());
  }

  @Override
  public void unregisterServer(ServerRecieveAlarmServicePrx serverToUnregister, Current current) {
    servers.remove(serverToUnregister);
    System.out.println("Server eliminado: " + serverToUnregister.toString());
  }

  @Override
  public void sendAlarm(int codMaquina,String type,String idInsumo, String idSumin, String idIngrediente, double cantidad, Moneda moneda, AlarmaServicePrx alarmaServicePrx, Current current) {
    ServerRecieveAlarmServicePrx server = locateServer();
    System.out.println("Server seleccionado: " + server.toString());
    try {
      System.out.println("Enviando alarma al servidor: " + server.toString());
      server.receiveAlarm(codMaquina,type,idInsumo,idSumin,idIngrediente,cantidad,moneda,alarmaServicePrx);
    } catch (Exception e) {
      System.err.println("Error al procesar la alarma en el servidor: " + server.toString());
    }
  }
  
}
