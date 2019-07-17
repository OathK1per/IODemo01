package IO05;

import java.io.*;

/**
 * 字符流：Reader&Writer
 */
public class ReadByChar {

    public static void main(String[] args) {
        File file = new File("src/resources/简单问题与解决办法");
        Reader rd = null;
        try {
            rd = new FileReader(file);
            char[] array = new char[1024];  //char[] not byte[]
            int len = -1;
            while ((len = rd.read(array)) != -1) {
                String result = new String(array, 0, len);
                System.out.println(result);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
