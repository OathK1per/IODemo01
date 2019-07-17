package IO06;

import java.io.*;

/**
 * 写出到字节数组中，不写入到具体文件中
 */
public class ByteArrayOutput {

    /**
     * 存放在字节数组中，不需要关闭，只使用内存，数据量不宜过大
     * @param args
     */
    public static void main(String[] args) {

        File file = new File("src/resources/WeChat Image_20190602031908.jpg");
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            is = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            System.out.println(baos.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
