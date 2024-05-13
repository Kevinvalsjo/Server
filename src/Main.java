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
        System.out.println("Räkna lite med " + portnumber);
// Determine the IP address of a host, given the host name InetAddress group =
        InetAddress group = InetAddress.getByName("225.4.5.6");
// getByName- returns IP address of given host
        serverMulticastSocket.joinGroup(group);
        System.out.println("Hämtar...");
        boolean infinite = true;


        while (infinite) {
            byte buf[] = new byte[1024];
            DatagramPacket data =
                    new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data);

            DatagramPacket data2 =
                    new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data2);


            DatagramPacket data3 =
                    new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data3);


            DatagramPacket data4 =
                    new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data4);



            DatagramPacket data5 =
                    new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data5);




            String msg =  new String(data.getData()).trim();


            String msg2 = new String(data2.getData()).trim();


            String msg3 = new String(data3.getData()).trim();


            String msg4 = new String(data4.getData()).trim();


            String msg7 = new String(data5.getData()).trim();
int msg9= Integer.parseInt(msg7);

            if (msg9==1) {
                int msg5 = Integer.parseInt(msg) + Integer.parseInt(msg2);
                System.out.println(msg + " + " + msg2 + " = " + msg5);
            }

            else{
                int msg8 = Integer.parseInt(msg3) * Integer.parseInt(msg4);
                System.out.println(msg3 + " * " + msg4 + " = " + msg8);
            }





            }
        serverMulticastSocket.close();
        }
    }
