
module servicios{

    sequence<string> StringArr;
    ["java:type:java.util.ArrayList<String>"] 
    sequence<string> StringSeq;
    ["java:serializable:java.util.Date"]
    sequence<byte> Date;

    dictionary<string,int> MapStrInt;


    interface ServicioComLogistica{

      StringSeq asignacionMaquina(int codigoOperador);
	    StringSeq asignacionMaquinasDesabastecidas(int codigoOperador);
	    bool inicioSesion(int codigoOperador, string password);
    }

    interface ServicioAbastecimiento {
	   void abastecer(int codMaquina, int tipoAlarma);
    }

    enum Moneda{
      CIEN, DOCIENTOS, QUINIENTOS
    }
  


    interface AlarmaService{
      void recibirNotificacionEscasezIngredientes(string iDing, int idMaq);
      void recibirNotificacionInsuficienciaMoneda(Moneda moneda, int idMaq);
      void recibirNotificacionEscasezSuministro(string idSumin, int idMaq);
      void recibirNotificacionAbastesimiento(int idMaq, string idInsumo, int cantidad );
      void recibirNotificacionMalFuncionamiento(int idMaq, string descri);

    }

    interface VentaService{
      void registrarVenta(int codMaq, StringArr ventas);
    }

    interface RecetaService{
      StringArr consultarIngredientes();
	    StringArr consultarRecetas();
      StringArr consultarProductos();
      void definirProducto(string nombre, int precio, MapStrInt ingredientes);

	    void borrarReceta(int cod);
	    void definirRecetaIngrediente(int idReceta, int idIngrediente,int valor);
	    string registrarReceta(string nombre, int precio);
	    string registrarIngrediente(string nombre);
    }

<<<<<<< HEAD
=======

>>>>>>> ec5f44c03f24a137d6cbe2ca1a787116396a22c8
    interface Suscriber{

      void notify();
      
    }

    interface Publisher {

      void subscribe(Suscriber* sb);

    }

<<<<<<< HEAD
=======

>>>>>>> ec5f44c03f24a137d6cbe2ca1a787116396a22c8
    interface BrokerService{
         void sendResponse(string serverName, string clientName, string response);
         void registerServer(Suscriber* subscriber);
         void receiveAck(string serverName, string clientName);
         void registerClient(Suscriber* subscriber);
         void receiveActualization(string serverName, string clientName);
         void sendAlarm(string serverName, string clientName);
         void unregisterClient(Suscriber* subscriber);
         void unregisterServer(Suscriber* subscriber);
         void notify(string serverName, string clientName);
         void subscribe(Suscriber* subscriber);
        }
}