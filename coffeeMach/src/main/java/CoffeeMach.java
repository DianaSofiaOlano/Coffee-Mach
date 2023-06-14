import com.zeroc.Ice.*;

import McControlador.ControladorMQ;
import productoReceta.SubscriberImpl;

import java.util.*;
import servicios.*;

public class CoffeeMach {
  public static void main(String[] args) {
    List<String> extPar = new ArrayList<>();
    try (Communicator communicator = Util.initialize(args, "coffeMach.cfg", extPar)) {

      AlarmaServicePrx alarmaS = AlarmaServicePrx.checkedCast(
          communicator.propertyToProxy("alarmas")).ice_twoway();
      VentaServicePrx ventas = VentaServicePrx.checkedCast(
          communicator.propertyToProxy("ventas")).ice_twoway();
      RecetaServicePrx recetaServicePrx = RecetaServicePrx.checkedCast(
          communicator.propertyToProxy("recetas")).ice_twoway();
      PublisherPrx publisherPrx = PublisherPrx.checkedCast(
          communicator.propertyToProxy("publisher")).ice_twoway();

      ObjectAdapter adapter = communicator.createObjectAdapter("CoffeMach");
      ControladorMQ service = new ControladorMQ();
      SubscriberImpl subscriber = new SubscriberImpl();
      service.setAlarmaService(alarmaS);
      service.setVentas(ventas);
      service.setRecetaServicePrx(recetaServicePrx);

      service.run();
      adapter.add((ServicioAbastecimiento) service, Util.stringToIdentity("abastecer"));
      ObjectPrx objectPrx = adapter.add(subscriber, Util.stringToIdentity("subscriber"));
      SuscriberPrx subscriberPrx = SuscriberPrx.checkedCast(objectPrx);
      publisherPrx.subscribe(subscriberPrx);
      adapter.activate();
      communicator.waitForShutdown();
    }
  }
}
