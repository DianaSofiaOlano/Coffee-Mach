import java.util.ArrayList;
import java.util.Random;

import com.zeroc.Ice.Current;

import servicios.BrokerService;
import servicios.SuscriberPrx;

public class BrokerI implements BrokerService {

  private ArrayList<SuscriberPrx> servers;
  private ArrayList<SuscriberPrx> clients;

  private SuscriberPrx locateServer() {
        Random random = new Random();
        int index = random.nextInt(servers.size());
        return servers.get(index);
   }

  @Override
  public void sendResponse(String serverName, String clientName, String response, Current current) {
    System.out.println("SendResponse: " + serverName + " " + clientName + " " + response);
  }

  @Override
  public void registerServer(SuscriberPrx serverToRegister, Current current) {
    servers.add(serverToRegister);
  }

  @Override
  public void receiveAck(String serverName, String clientName, Current current) {
    System.out.println("ReceiveAck: " + serverName + " " + clientName);
  }

  @Override
  public void registerClient(SuscriberPrx clientToRegister, Current current) {
    clients.add(clientToRegister);
  }

  @Override
  public void receiveActualization(String serverName, String clientName, Current current) {
    System.out.println("ReceiveActualization: " + serverName + " " + clientName);
  }

  @Override
  public void sendAlarm(String serverName, String clientName, Current current) {
    System.out.println("SendAlarm: " + serverName + " " + clientName);
  }

  @Override
  public void unregisterClient(SuscriberPrx clientToUnregister, Current current) {
    clients.remove(clientToUnregister);
  }

  @Override
  public void unregisterServer(SuscriberPrx serverToUnregister, Current current) {
    servers.remove(serverToUnregister);
  }

  @Override
  public void _notify(String serverName, String clientName, Current current) {
    System.out.println("Notify: " + serverName + " " + clientName);
  }

  @Override
  public void subscribe(SuscriberPrx serverToUnregister, Current current) {
    servers.add(serverToUnregister);
  }
      
}
