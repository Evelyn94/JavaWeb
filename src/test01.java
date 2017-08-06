import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by linhonggu on 20/6/17.
 */
public class test01 {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("主机名：" + address.getHostName());
        System.out.println("主机地址：" + address.getHostAddress());
        byte[] bytes = address.getAddress();//获取字节数组形式的IP地址
        System.out.println("byte IP:" + Arrays.toString(bytes));
        System.out.println("address:" + address);
        //根据计算机名获取InetAdress实例

        InetAddress address1 = InetAddress.getByName("林红谷's MacBook pro");
        System.out.println("address1:" + address1);
    }
}
