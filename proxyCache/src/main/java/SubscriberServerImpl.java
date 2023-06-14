import com.zeroc.Ice.Current;

import servicios.Suscriber;

public class SubscriberServerImpl implements Suscriber{

    @Override
    public void _notify(Current current) {
        System.out.println("Notified");
    }
    
}
