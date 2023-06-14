package productoReceta;

import com.zeroc.Ice.Current;

import McControlador.ControladorMQ;
import servicios.PublisherPrx;
import servicios.Suscriber;

public class SubscriberImpl implements Suscriber{

    //private PublisherPrx proxy;
    private ControladorMQ controller;

    public SubscriberImpl() {
        //this.proxy = proxy;
    }

    public void setController(ControladorMQ controller) {
        this.controller = controller;
    }

    @Override
    public void notifyChange(String[] receta, Current current) {
        System.out.println("Recetas actualizadas");
        controller.cargarRecetaMaquinas(receta);
    }


    
}
