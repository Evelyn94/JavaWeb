package communication;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by linhonggu on 20/6/17.
 */
public class server {
    public static void main(String[] args) {

        try {
            // 1.create a server socket, specify the binding port and 监听
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            int count = 0;
                    // 2.use accept() method for 监听，waiting for the client to connect
            System.out.println("****The server is about to start working, waiting for the client to connect****");
            while (true){
                // use accept()method for supervise, waiting for the client to connect
                socket = serverSocket.accept();
                // create a new thread
                ServerThread serverThread = new ServerThread(socket);
                // start the thread
                serverThread.start();

                count ++;
                System.out.println("client number:" + count);
                InetAddress address = socket.getInetAddress();
                System.out.println("current client IP:" + address.getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
