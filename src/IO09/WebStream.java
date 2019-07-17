package IO09;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 操作网络流,从字节流到字符流的转换,InputStreamReader 是一个Reader流
 */
public class WebStream {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new URL("https://www.baidu.com/").openStream(), "UTF-8");
        char[] array = new char[1024];
        int len;
        while ((len = isr.read(array)) != -1) {
            System.out.print(new String(array, 0, len));
        }
    }
}
