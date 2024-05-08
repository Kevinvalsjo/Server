import java.net.*;
public class Main {
    public static void main(String args[]) throws Exception {
// Default port number we are going to use
        int portnumber = 1111;
        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[0]);
        }

// Create a MulticastSocket
        MulticastSocket serverMulticastSocket =
                new MulticastSocket (portnumber);
        System.out.println("Räkna lite med " + portnumber);
// Determine the IP address of a host, given the host name InetAddress group =
        InetAddress group=  InetAddress.getByName("225.4.5.6");
// getByName- returns IP address of given host
        serverMulticastSocket.joinGroup (group);
        System.out.println("Calling....");
        boolean infinite = true;


        while(infinite){
            byte buf[]= new byte[1024];
            DatagramPacket data =
                    new DatagramPacket (buf, buf.length);
            serverMulticastSocket.receive(data);

            DatagramPacket data2 =
                    new DatagramPacket (buf, buf.length);
            serverMulticastSocket.receive(data2);
            String msg =
                    new String(data.getData()).trim();

            String msg2 = new String(data2.getData()).trim();

            int msg3= Integer.parseInt(msg)+Integer.parseInt(msg2);
            System.out.println(" Ok " +msg+ " + " +msg2+ " = " +msg3);

        }
        serverMulticastSocket.close();

    }

}
