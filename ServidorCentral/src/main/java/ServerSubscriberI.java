import com.zeroc.Ice.Current;

import servicios.AlarmaServicePrx;
import servicios.ServerSubscriber;

public class ServerSubscriberI implements ServerSubscriber {

  @Override
  public void sendAlarm(AlarmaServicePrx alarmaService, Current current) {
    System.out.println("Alarma recibida: " + alarmaService.toString());
  }
  
  
}
