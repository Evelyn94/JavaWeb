package communication;

import java.io.IOException;
import java.net.*;

/**
 * Created by linhonggu on 21/6/17.
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
        // 1. define the InetAdress, port and data of server
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8800;
        byte[] data = "user: admin; password: 123".getBytes();
        // 2. create datagram and send the data
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        // 3. create DatagramSocket object
        DatagramSocket socket = new DatagramSocket();
        // 4. sent datagram to server
        socket.send(packet);
        // 5. receive the data sent by the server
        //// 5.1 create the data byte and the datapacket that used to store the received data
        byte[] data1 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data1, data1.length);
        //// 5.2 receive the answer data from the server
        socket.receive(packet1);
        //// 5.3 read the data
        String reply = new String(data1, 0, packet1.getLength());
        System.out.println("I am client, the server say:" + reply);
        //// 5.4 close the resource
        socket.close();
    }
}
