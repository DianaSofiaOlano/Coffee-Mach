import com.zeroc.Ice.Current;

import servicios.BrokerService;

public class BrokerI implements BrokerService {

  @Override
  public void locateClient(String clientName, Current current) {
    System.out.println("LocateClient: " + clientName);
  }

  @Override
  public void locateServer(String serverName, Current current) {
    System.out.println("LocateServer: " + serverName);
  }

  @Override
  public void sendRequest(String clientName, String serverName, String request, Current current) {
    System.out.println("SendRequest: " + clientName + " " + serverName + " " + request);
  }

  @Override
  public void sendResponse(String serverName, String clientName, String response, Current current) {
    System.out.println("SendResponse: " + serverName + " " + clientName + " " + response);
  }

  @Override
  public void registerServer(String serverName, Current current) {
    System.out.println("RegisterServer: " + serverName);
  }

  @Override
  public void receiveAck(String serverName, String clientName, Current current) {
    System.out.println("ReceiveAck: " + serverName + " " + clientName);
  }

  @Override
  public void registerClient(String clientName, Current current) {
    System.out.println("RegisterClient: " + clientName);
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
  public void unregisterClient(String clientName, Current current) {
    System.out.println("UnregisterClient: " + clientName);
  }

  @Override
  public void unregisterServer(String serverName, Current current) {
    System.out.println("UnregisterServer: " + serverName);
  }

  @Override
  public void _notify(String serverName, String clientName, Current current) {
    System.out.println("Notify: " + serverName + " " + clientName);
  }

  @Override
  public void subscribe(String serverName, String clientName, Current current) {
    System.out.println("Subscribe: " + serverName + " " + clientName);
  }
        
        

}
