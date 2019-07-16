package IO04;

import java.io.*;

public class Copy {

    public static void main(String[] args) {
        File source = new File("src/resources/dest.txt");
        File dest = new File("src/resources/source.txt");

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);

            byte[] array = new byte[1024];
            int len = -1;
            while ((len = is.read(array)) != -1) {
                os.write(array, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(is != null) {
                    is.close();
                }
                if(os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
