import java.util.*;
import com.zeroc.Ice.*;

import servicios.PublisherPrx;
import servicios.SuscriberPrx;


public class ProxyCache {
    public static void main(String[] args) {
        List<String> extArgs = new ArrayList<>();
        try (Communicator communicator = Util.initialize(args, "ProxyCache.cfg", extArgs)) {


            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Publisher");
            com.zeroc.Ice.Object publisherImpl = new PublisherImpl();

            PublisherPrx publisherPrx = PublisherPrx.checkedCast(
            communicator.propertyToProxy("publisher")).ice_twoway();

            SubscriberServerImpl subscriberServerImpl = new SubscriberServerImpl();
            subscriberServerImpl.setPublisher((PublisherImpl) publisherImpl);
            ObjectPrx objectPrx = adapter.add(subscriberServerImpl, Util.stringToIdentity("subscriber"));
            SuscriberPrx subscriberPrx = SuscriberPrx.checkedCast(objectPrx);
            publisherPrx.subscribe(subscriberPrx);
            System.out.println("Subscribed to server ready");


            adapter.add(publisherImpl, com.zeroc.Ice.Util.stringToIdentity("Publisher"));
            System.out.println("Publisher ready");
            adapter.activate();
            communicator.waitForShutdown();


        }
    }
}
