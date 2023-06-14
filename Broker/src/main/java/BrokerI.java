import java.util.ArrayList;

import com.zeroc.Ice.Current;

import servicios.AlarmaServicePrx;
import servicios.BrokerService;
import servicios.ClientSubscriberPrx;
import servicios.ServerSubscriberPrx;



public class BrokerI implements BrokerService {

  /* Servidores Centrales */
  private ArrayList<ServerSubscriberPrx> servers;
  /* Maquinas de cafe */
  private ArrayList<ClientSubscriberPrx> clients;
  private int currentServerIndex = 0;

  private ServerSubscriberPrx locateServer() {
     ServerSubscriberPrx selectedServer = servers.get(currentServerIndex);
     currentServerIndex = (currentServerIndex + 1) % servers.size();
     return selectedServer;
  }
   
  @Override
  public void registerServer(ServerSubscriberPrx serverToRegister, Current current) {
    servers.add(serverToRegister);
  }
  
  @Override
  public void registerClient(ClientSubscriberPrx clientToRegister, Current current) {
    clients.add(clientToRegister);
  }

  @Override
  public void receiveUpdate(ClientSubscriberPrx clientSubscriberPrx, Current current) {
    for (ClientSubscriberPrx client : clients) {
            try {
                client.receiveUpdate();
            } catch (Exception e) {
                // Manejar excepciones al notificar a los clientes desde el broker
            }
        }
  }

  @Override
  public void sendAlarm(AlarmaServicePrx alarmaServicePrx, Current current) {
    ServerSubscriberPrx server = locateServer();
    server.sendAlarm(alarmaServicePrx);
  }

  @Override
  public void unregisterClient(ClientSubscriberPrx clientToUnregister, Current current) {
    clients.remove(clientToUnregister);
  }

  @Override
  public void unregisterServer(ServerSubscriberPrx serverToUnregister, Current current) {
    servers.remove(serverToUnregister);
  }

  @Override
  public void _notify(Current current) {
    for (ServerSubscriberPrx server : servers) {
            try {
                server.notify();
            } catch (Exception e) {
                // Manejar excepciones al notificar a los clientes desde el servidor
            }
        }
  }

  @Override
  public void subscribe(ClientSubscriberPrx clientSubscriberPrx, Current current) {
    locateServer().subscribe(clientSubscriberPrx);
  }
      
}
