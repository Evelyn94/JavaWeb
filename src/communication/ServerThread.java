package communication;

import java.io.*;
import java.net.Socket;

/**
 * Created by linhonggu on 20/6/17.
 */
public class ServerThread extends Thread {
    Socket socket = null;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        // 3.obtain the input stream and read the client message
        InputStream is = null;//byte input stream
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine()) != null){
                System.out.println("I am server, the client say:" + info);
            }
            socket.shutdownInput();//close input stream
            // 4. obtain output stream and respond to the client
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("welcome!");
            pw.flush();//clear the buffer output
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 5. close the resource
            try {
                if(br != null)
                    br.close();
                if(isr != null)
                    isr.close();
                if(is != null)
                    is.close();
                if(pw != null)
                    pw.close();
                if(os != null)
                    os.close();
                if(socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }





    }
}
