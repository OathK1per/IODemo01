package IO09;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用Buffered装饰下的网络流，同时从字节流到字符流的转换
 */
public class BufferedWebStreamConvert {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(new URL("https://www.baidu.com").openStream(), "UTF-8"));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/resources/baidu.html"), "UTF-8"))) {
            String ans;
            // 当没有内容时返回的是null
            while ((ans = rd.readLine()) != null) {
                wr.write(ans);
                wr.newLine();
            }
            wr.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
