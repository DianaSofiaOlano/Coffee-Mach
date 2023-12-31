
import java.util.ArrayList;
import java.util.List;
import com.zeroc.Ice.*;
import comunicacion.*;
import interfaz.ControladorRecetas;
import receta.ProductoReceta;
import receta.PublisherProxyImpl;
import servicios.*;
import ventas.VentasManager;
import ServerControl.*;
import alarma.Alarma;
import alarma.AlarmasManager;

public class ServidorCentral {

    public static void main(String[] args) {
        List<String> params = new ArrayList<>();
        try (Communicator communicator = Util.initialize(args, "server.cfg", params)) {

            ObjectAdapter adapter = communicator.createObjectAdapter("Server");

            ObjectAdapter adapter2 = communicator.createObjectAdapter("Publisher");

            ServerControl control = new ServerControl(communicator);

            ServicioComLogistica log = new ControlComLogistica(control);

            Alarma alarma = new Alarma(new AlarmasManager(communicator));

            

            ProductoReceta recetas = new ProductoReceta();
            recetas.setCommunicator(communicator);

            VentasManager ventas = new VentasManager();
            ventas.setCommunicator(communicator);

            PublisherProxyImpl publisher = new PublisherProxyImpl();
            ServerReceiveAlarmServiceI receiveAlarms = new ServerReceiveAlarmServiceI();

            adapter.add(alarma, Util.stringToIdentity("Alarmas"));
            adapter.add(ventas, Util.stringToIdentity("Ventas"));
            adapter.add(log, Util.stringToIdentity("logistica"));
            adapter.add(recetas, Util.stringToIdentity("Recetas"));
            adapter2.add(publisher, Util.stringToIdentity("Publisher"));
            adapter.add(receiveAlarms, Util.stringToIdentity("receiveAlarms"));

            // Obtener el proxy del servidor
            com.zeroc.Ice.ObjectPrx serverProxy = adapter
                .createProxy(com.zeroc.Ice.Util.stringToIdentity("receiveAlarms"));
            
            
            // Crear el objeto de servicio
            ServerRecieveAlarmServicePrx serverAlarm = ServerRecieveAlarmServicePrx.checkedCast(serverProxy);

            // Clase que implementa el servicio de recibir alarmas
            BrokerServicePrx brokerServicePrx = BrokerServicePrx
                .checkedCast(communicator.stringToProxy("Broker:tcp -h localhost -p 12347")).ice_twoway();
                    
            brokerServicePrx.registerServer(serverAlarm, null);

            ControladorRecetas controladorRecetas = new ControladorRecetas();
            controladorRecetas.setRecetaService(recetas);
            controladorRecetas.setPublisher(publisher);
            controladorRecetas.run();

            adapter.activate();
            adapter2.activate();
            communicator.waitForShutdown();

        }
    }
}
