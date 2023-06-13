import java.util.*;
import com.zeroc.Ice.*;

import servicios.PublisherPrx;

public class ProxyCache {
    public static void main(String[] args) {
        List<String> extArgs = new ArrayList<>();
        try (Communicator communicator = Util.initialize(args, "ProxyCache.cfg", extArgs)) {

            PublisherPrx publisherPrx = servicios.PublisherPrx.
                    checkedCast(communicator.propertyToProxy("PublisherPrx.Proxy")).ice_twoway();

        }
    }
}
