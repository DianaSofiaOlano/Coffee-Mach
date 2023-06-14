import com.zeroc.Ice.ObjectAdapter;

import servicios.ServerRecieveAlarmServicePrx;

public class Broker {

   public static void main(String[] args)
    {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "broker.cfg"))
        {
            // Crear un adaptador de objetos
            ObjectAdapter adapter = communicator.createObjectAdapter("Broker");

            // Crear una instancia del Broker
            BrokerI broker = new BrokerI();

            // Agregar el Broker al adaptador
            adapter.add(broker, com.zeroc.Ice.Util.stringToIdentity("Broker"));
  
            // Activar el adaptador
            adapter.activate();
            System.out.println("Broker iniciado. Esperando conexiones...");

            // Esperar a que se cierre la aplicación
            communicator.waitForShutdown();
        }
    }
  
}
