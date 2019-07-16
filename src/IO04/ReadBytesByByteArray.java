package IO04;

import java.io.*;

public class ReadBytesByByteArray {

    public static void main(String[] args) {
        File file = new File("src/resources/简单问题与解决办法");
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            byte[] array = new byte[1024];
            int len = -1;
            while ((len = is.read(array)) != -1) {
                // 分段读取
                String str = new String(array, 0, len);
                System.out.println(str);
            }

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
