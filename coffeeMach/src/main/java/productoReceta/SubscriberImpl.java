package productoReceta;

import com.zeroc.Ice.Current;

import servicios.PublisherPrx;
import servicios.Suscriber;

public class SubscriberImpl implements Suscriber{

    //private PublisherPrx proxy;

    public SubscriberImpl() {
        //this.proxy = proxy;
    }


    @Override
    public void _notify(Current current) {
        System.out.println("Notified");
    }


    
}
