import java.util.Map;

import java.util.HashMap;

import com.zeroc.Ice.Current;

import   servicios.Publisher;
import servicios.SuscriberPrx;
public class PublisherImpl implements Publisher{

    Map <String, SuscriberPrx> suscribers = new HashMap<>();


    @Override
    public void subscribe(SuscriberPrx sb, Current current) {
        String address = getAddress(sb.toString());
        if(!suscribers.containsKey(address)){
            suscribers.put(address, sb);
            System.out.println("Client subscribed: " + address);
        }
    }

    private String getAddress(String sb) {
        String temp = sb.substring(sb.indexOf('h') + 1);
        return temp.substring(temp.indexOf('h') + 2, temp.indexOf('-') - 1);
    }
    
}
