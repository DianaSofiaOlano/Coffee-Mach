import com.zeroc.Ice.Current;

import servicios.AlarmaServicePrx;
import servicios.ServerRecieveAlarmService;
public class ServerReceiveAlarmServiceI implements ServerRecieveAlarmService {

  @Override
  public void receiveAlarm(AlarmaServicePrx alarmaService, Current current) {
    System.out.println("Alarma recibida: " + alarmaService.toString());
  }
  
  
}
