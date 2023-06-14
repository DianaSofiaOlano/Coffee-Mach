import java.util.ArrayList;

import com.zeroc.Ice.Current;

import servicios.AlarmaServicePrx;
import servicios.BrokerService;
import servicios.ServerSubscriberPrx;



public class BrokerI implements BrokerService {

  /* Servidores Centrales */
  private ArrayList<ServerSubscriberPrx> servers;
  private int currentServerIndex = 0;

  // Función para localizar un servidor central disponible
  private ServerSubscriberPrx locateServer() {
    ServerSubscriberPrx selectedServer = servers.get(currentServerIndex);
    currentServerIndex = (currentServerIndex + 1) % servers.size();
    return selectedServer;
  }

  @Override
  public void registerServer(ServerSubscriberPrx serverToRegister, Current current) {
    servers.add(serverToRegister);
    System.out.println("Server registrado: " + serverToRegister.toString());
  }

  @Override
  public void unregisterServer(ServerSubscriberPrx serverToUnregister, Current current) {
    servers.remove(serverToUnregister);
    System.out.println("Server eliminado: " + serverToUnregister.toString());
  }

  @Override
  public void sendAlarm(AlarmaServicePrx alarmaServicePrx, Current current) {
    ServerSubscriberPrx server = locateServer();
    try {
      server.sendAlarm(alarmaServicePrx);
    } catch (Exception e) {
      System.err.println("Error al procesar la alarma en el servidor: " + server.toString());
    }
  }
  
}
