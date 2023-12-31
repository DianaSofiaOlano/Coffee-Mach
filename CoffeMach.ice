
module servicios{

    sequence<string> StringArr;
    ["java:type:java.util.ArrayList<String>"] 
    sequence<string> StringSeq;
    ["java:serializable:java.util.Date"]
    sequence<byte> Date;

    dictionary<string,int> MapStrInt;

    sequence<int> ItemsOrden;

    interface ServicioComLogistica{

      StringSeq asignacionMaquina(int codigoOperador);
	    StringSeq asignacionMaquinasDesabastecidas(int codigoOperador);
	    bool inicioSesion(int codigoOperador, string password);
    }

    interface RMReceiver{
        void recibirAlarma(int idOrder, int idMaquina, int idOperador, string fecha, string ubicacion, ItemsOrden itemsOrden);
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


    interface Suscriber{

      void notifyChange(StringArr receta);
      
    }

    interface Publisher {
      void subscribe(Suscriber* sb);

    }

    interface ServerRecieveAlarmService{
      void receiveAlarm(int codMaquina,string type,string idInsumo, string idSumin, string idIngrediente, double cantidad,Moneda moneda, AlarmaService* alarmaService);
    }

    interface BrokerService{
         void registerServer(ServerRecieveAlarmService* subscriber);
         void unregisterServer(ServerRecieveAlarmService* subscriber);
         void sendAlarm(int codMaquina,string type,string idInsumo, string idSumin, string idIngrediente, double cantidad,Moneda moneda, AlarmaService* alarmaService);
        }
}