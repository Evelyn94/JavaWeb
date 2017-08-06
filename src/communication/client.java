package communication;

import java.io.*;
import java.net.Socket;

/**
 * Created by linhonggu on 20/6/17.
 */
public class client {
    public static void main(String[] args) {
        try {
            // 1. create client Socket, specify the server address and port.
            Socket socket = new Socket("localhost", 8888);
            // 2. obtain OutputStream, send message to server
            OutputStream os = socket.getOutputStream();// byte output stream
            PrintWriter pw = new PrintWriter(os);
            pw.write("user: Bob; password: 456");
            pw.flush();
            socket.shutdownOutput();//close output stream

            // 3. obtain InputStream, print the message.
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String data = null;
            while ((data=br.readLine()) != null){
                System.out.println("I am client, the server say:"+ data);
            }
            socket.shutdownInput();

            // 4. close resource.
            pw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
