import java.net.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class Main {
    public static void main(String args[]) throws Exception {
// Default port number we are going to use
        int portnumber = 1111;
        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[0]);
        }

// Create a MulticastSocket
        MulticastSocket serverMulticastSocket =
                new MulticastSocket(portnumber);
        System.out.println("Räkna");
// Determine the IP address of a host, given the host name InetAddress group =
        InetAddress group = InetAddress.getByName("225.4.5.6");
// getByName- returns IP address of given host
        serverMulticastSocket.joinGroup(group);
        System.out.println("");
        boolean infinite = true;


        while (infinite) {
            byte buf[] = new byte[1024];
            String msg,msg2,msg3,msg4,msg7;
            int msg9,msg5,msg8;
            DatagramPacket data,data2,data3,data4,data5;

            data5 =
                    new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data5);

            msg7 = new String(data5.getData()).trim();
             msg9= Integer.parseInt(msg7);

switch(msg9) {
    case 1 ->{
        System.out.println("addition");
        data =
                new DatagramPacket(buf, buf.length);
        serverMulticastSocket.receive(data);


        msg = new String(data.getData()).trim();
        data2 =
                new DatagramPacket(buf, buf.length);
        serverMulticastSocket.receive(data2);
        msg2 = new String(data2.getData()).trim();

        msg5 = Integer.parseInt(msg) + Integer.parseInt(msg2);
        System.out.println("Summan av " + msg + " + " + msg2 + " = " + msg5);


    }
    case 2 -> {
        System.out.println("Multiplikation");
        data3 =
                new DatagramPacket(buf, buf.length);
        serverMulticastSocket.receive(data3);


        msg3 = new String(data3.getData()).trim();

        data4 =
                new DatagramPacket(buf, buf.length);
        serverMulticastSocket.receive(data4);

        msg4 = new String(data4.getData()).trim();


        msg8 = Integer.parseInt(msg3) * Integer.parseInt(msg4);
        System.out.println("Produkten av " + msg3 + " * " + msg4 + " = " + msg8);
    }
    case 3 ->{
        infinite=false;
        serverMulticastSocket.close();
    }

}










        }


        }
    }
