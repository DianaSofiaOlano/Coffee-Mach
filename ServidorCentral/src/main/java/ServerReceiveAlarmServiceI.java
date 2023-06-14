import com.zeroc.Ice.Current;

import servicios.AlarmaServicePrx;
import servicios.ServerRecieveAlarmService;
public class ServerReceiveAlarmServiceI implements ServerRecieveAlarmService {

  @Override
  public void receiveAlarm(int codMaquina, String type, AlarmaServicePrx alarmaService, Current current) {
    System.out
        .println("Alarma recibida de tipo: " + type + " de la máquina: " + codMaquina + " en el servidor central.");
    switch (type) {
      case "1":
        alarmaService.recibirNotificacionMalFuncionamiento(codMaquina,"Se requiere mantenimiento por mal funcionamiento");
        break;
    }
  }

  
  
  
}
