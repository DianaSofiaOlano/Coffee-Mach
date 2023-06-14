import com.zeroc.Ice.Current;

import servicios.Suscriber;


public class SubscriberServerImpl implements Suscriber {

    private String[] recetas;
    private PublisherImpl publisherImpl;

    public SubscriberServerImpl() {
        recetas = new String[0];
    }

    public void setRecetas(String[] recetas) {
        this.recetas = recetas;
    }

    public void setPublisher(PublisherImpl publisherImpl) {
        this.publisherImpl = publisherImpl;
    }

    @Override
    public void notifyChange(String[] receta, Current current){
        setRecetas(receta);
        System.out.println("Recetas actualizadas");
        publisherImpl.notifyAll(recetas);
    }
    

}
