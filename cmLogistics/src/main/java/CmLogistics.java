import java.util.*;
import com.zeroc.Ice.*;

public class CmLogistics {
    public static void main(String[] args) {
        List<String> extArgs = new ArrayList<>();
        try (Communicator communicator = Util.initialize(args, "CmLogistic.cfg", extArgs)) {

            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Receiver");

            com.zeroc.Ice.Object receiverImpl = new RMReceiverImpl();

            adapter.add(receiverImpl, com.zeroc.Ice.Util.stringToIdentity("RMReceiver"));
            adapter. Activate();
        }
    }
}
