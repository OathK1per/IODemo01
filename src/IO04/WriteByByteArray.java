package IO04;

import java.io.*;

public class WriteByByteArray {

    public static void main(String[] args) {
        File dest = new File("src/resources/dest.txt");

        OutputStream os = null;

        try {
            os = new FileOutputStream(dest);
            String init = "Seattle or San Diego?";
            byte[] bytes = init.getBytes();
            os.write(bytes);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
