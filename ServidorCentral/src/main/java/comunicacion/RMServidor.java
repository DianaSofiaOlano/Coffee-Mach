import java.io.*;
import java.net.Socket;
import servicios.RMservice;

public class RMServidor implements RMservice{

  // Atributos
  private Orden orden;
  // Registro de órdenes enviadas
  private Set<String> processedOrders = new HashSet<>();

  public void sendOrders(int idOrder, int idMaquina, int idOperador, string fecha, string ubicacion, ItemsOrden itemsOrden) {
    
    this.orden.setId(idOrder);
    this.orden.setIdMaquinaCafe(idMaquina);
    this.orden.setIdOperador(idOperador);
    this.orden.setUbicacion(ubicacion);
    this.orden.setItemsOrden(itemsOrden);

    
    String bodegaHost = "idkYet";
    int bodegaPort = 12345;

    String logisticaHost = "idkYet";
    int logisticaPort = 54321;

    try {
      // Establecer conexión con la bodega
      Socket bodegaSocket = new Socket(bodegaHost, bodegaPort);
      ObjectOutputStream bodegaOutputStream = new ObjectOutputStream(bodegaSocket.getOutputStream());
      ObjectInputStream bodegaInputStream = new ObjectInputStream(bodegaSocket.getInputStream());

      // Establecer conexión con la logística
      Socket logisticaSocket = new Socket(logisticaHost, logisticaPort);
      ObjectOutputStream logisticaOutputStream = new ObjectOutputStream(logisticaSocket.getOutputStream());
      ObjectInputStream logisticaInputStream = new ObjectInputStream(logisticaSocket.getInputStream());

      // Crear hilo para enviar las órdenes
      Thread sendThread = new Thread(() -> {
        boolean bodegaDeliveryConfirmed = false;
        boolean logisticaDeliveryConfirmed = false;
        int retryCountBodega = 0;
        int retryCountLogistica = 0;

        while ((!bodegaDeliveryConfirmed && !logisticaDeliveryConfirmed)) {
          try {
            if (!bodegaDeliveryConfirmed && (!processedOrders.contains(orden.getId()))) {
              // Enviar objeto Orden a la bodega
              bodegaOutputStream.writeObject(orden);
              bodegaOutputStream.flush();

              // Leer la confirmación de entrega de la bodega
              String bodegaDeliveryConfirmation = (String) bodegaInputStream.readObject();

              // Verificar si se recibió la confirmación de entrega de la bodega
              if (bodegaDeliveryConfirmation != null) {
                bodegaDeliveryConfirmed = true;
                System.out.println("Confirmación de entrega de la bodega: " + bodegaDeliveryConfirmation);
              } else {
                retryCountBodega++;
                System.out.println("Reintentando entrega a la bodega (" + retryCountBodega + ")");
              }
            }

            if (bodegaDeliveryConfirmed && !logisticaDeliveryConfirmed && (!processedOrders.contains(orden.getId()))) {
              // Enviar objeto Orden a la logística
              logisticaOutputStream.writeObject(orden);
              logisticaOutputStream.flush();

              // Leer la confirmación de entrega de la logística
              String logisticaDeliveryConfirmation = (String) logisticaInputStream.readObject();

              // Verificar si se recibió la confirmación de entrega de la logística
              if (logisticaDeliveryConfirmation != null) {
                logisticaDeliveryConfirmed = true;
                System.out.println("Confirmación de entrega de la logística: " + logisticaDeliveryConfirmation);
              } else {
                retryCountLogistica++;
                System.out.println("Reintentando entrega a la logística (" + retryCountLogistica + ")");
              }
            }
          } catch (IOException | ClassNotFoundException e) {
              e.printStackTrace();
              if (!bodegaDeliveryConfirmed) {
                retryCountBodega++;
                System.out.println("Reintentando entrega a la bodega (" + retryCountBodega + ")");
              } else {
                retryCountLogistica++;
                System.out.println("Reintentando entrega a la logística (" + retryCountLogistica + ")");
              }
          }

          // Dormir hilo durante 10 segundos antes del siguiente intento
          try {
            Thread.sleep(10000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

          if (bodegaDeliveryConfirmed && logisticaDeliveryConfirmed) {
            processedOrders.add(orden.getId());
            System.out.println("Entrega completada con éxito");
              
          } else {
            System.out.println("No se pudo completar la entrega");
          }
      });

        sendThread.start();

        // Esperar a que el hilo de envío termine antes de cerrar los recursos
        sendThread.join();

        // Cerrar los recursos
        bodegaOutputStream.close();
        bodegaInputStream.close();
        bodegaSocket.close();
        logisticaOutputStream.close();
        logisticaInputStream.close();
        logisticaSocket.close();
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
  }
}
