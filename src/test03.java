import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by linhonggu on 20/6/17.
 */
public class test03 {
    public static void main(String[] args) {
        try {
            // create a URL object
            URL url = new URL("http://www.baidu.com");
            // obtain the byte input stream resource represented by the URL object resource by openSteam() method of URL object
            InputStream is = url.openStream();
            // transfer the byte input stream into word input stream
            InputStreamReader isr = new InputStreamReader(is);
            // increase buffer for word input stream
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while (data != null){
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
