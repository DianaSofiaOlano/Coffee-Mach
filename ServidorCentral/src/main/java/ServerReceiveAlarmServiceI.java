import com.zeroc.Ice.Current;

import servicios.AlarmaServicePrx;
import servicios.Moneda;
import servicios.ServerRecieveAlarmService;
public class ServerReceiveAlarmServiceI implements ServerRecieveAlarmService {

  @Override
  public void receiveAlarm(int codMaquina,String type,String idInsumo, String idSumin, String idIngrediente, double cantidad, Moneda moneda, AlarmaServicePrx alarmaService, Current current) {
    System.out
        .println("Alarma recibida de tipo: " + type + " de la máquina: " + codMaquina + " en el servidor central.");
    switch (type) {
      case "1":
        alarmaService.recibirNotificacionMalFuncionamiento(codMaquina,"Se requiere mantenimiento por mal funcionamiento");
        break;
      case "2":
      case "3":
      case "4":
      case "5":
      case "6":
      case "7":
        alarmaService.recibirNotificacionInsuficienciaMoneda(moneda, codMaquina);
        break;
      case "8":
      case "9":
      case "10":
      case "11":
        alarmaService.recibirNotificacionEscasezIngredientes(idIngrediente, codMaquina);
        break;
      default:
        break;
    }
  }

  
  
  
}
