package communication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by linhonggu on 21/6/17.
 */
public class UDPServer {
    public static void main(String[] args) {

        try {
            // 1. create server DatagramSocket, specify port
            DatagramSocket socket = new DatagramSocket(8800);
            System.out.println("***I am server, waiting for the server to connect***");
            // 2. create datagram, used for accept data sent by the client
            byte[] data = new byte[1024];//create byte array, specify the amount of the datagram
            DatagramPacket packet = new DatagramPacket(data, data.length);
            // 3. accept data sent by the client
            socket.receive(packet);//this method will stay stuck until receive the datagram
            // 4. read the data
            String info = new String(data, 0, packet.getLength());
            System.out.println("I am server, the client say:" + info);

            // 5. answer the client
            //// 5.1 define the InetAdress, port and data
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data1 = "welcome!".getBytes();
            //// 5.2 create datagram, include the response data
            DatagramPacket packet1 = new DatagramPacket(data1, data1.length, address, port);
            //// 5.3 answer the client
            socket.send(packet1);
            //// 5.4 close the resource
            socket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
