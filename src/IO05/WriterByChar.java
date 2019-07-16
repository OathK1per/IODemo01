package IO05;

import java.io.*;

public class WriterByChar {

    public static void main(String[] args) {
        File dest = new File("src/resources/dest3.txt");

        Writer os = null;

        try {
            os = new FileWriter(dest);
            String init = "Seattle or San Diego?";
            /**
             * method one
             */
//            os.write(init, 0, init.length());
            /**
             * method two
             */
            os.append("Seattle").append(" or ").append("San Diego?");
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
