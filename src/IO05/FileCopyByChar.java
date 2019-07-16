package IO05;

import java.io.*;

public class FileCopyByChar {

    public static void main(String[] args) {
        File file = new File("src/resources/简单问题与解决办法");
        File file1 = new File("src/resources/dest2.txt");
        Reader rd = null;
        Writer wr = null;
        try {
            rd = new FileReader(file);
            wr = new FileWriter(file1);
            char[] array = new char[1024];
            int len = -1;
            while ((len = rd.read(array)) != -1) {
                wr.write(array, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rd.close();

                wr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
