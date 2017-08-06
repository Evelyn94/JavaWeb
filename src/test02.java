import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by linhonggu on 20/6/17.
 */
public class test02 {
    public static void main(String[] args) {
        try {
            // create a URL object
            URL imooc = new URL("http://www.imooc.com");
            // after ? is parameters, after # is 锚点
            URL url = new URL(imooc, "/index.html?username=tom#test");
            System.out.println("protocal:" + url.getProtocol());
            System.out.println("host:" + url.getHost());
            // if not specify a port, use default port and return -1 when use getPort()
            System.out.println("port:" + url.getPort());
            System.out.println("path:" + url.getPath());
            System.out.println("file:" + url.getFile());
            System.out.println("reference path:" + url.getRef());
            System.out.println("query string:" + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
