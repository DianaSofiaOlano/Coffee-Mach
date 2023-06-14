import java.util.ArrayList;
import java.util.Random;

import com.zeroc.Ice.Current;

import servicios.AlarmaServicePrx;
import servicios.BrokerService;
import servicios.ClientSubscriberPrx;
import servicios.RecetaServicePrx;
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
    clientSubscriberPrx.receiveUpdate();
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
  public void _notify(ClientSubscriberPrx clientSubscriberPrx,Current current) {
    clientSubscriberPrx._notify();
  }

  @Override
  public void subscribe(ServerSubscriberPrx serverSubscriberPrx, Current current) {
    serverSubscriberPrx.subscribe();
  }
      
}
