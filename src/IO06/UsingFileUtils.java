package IO06;

import java.io.*;

public class UsingFileUtils {

    public static void main(String[] args) {
        File file = new File("src/resources/source.txt");
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(file);
            os = new ByteArrayOutputStream();
            FileUtils.copy(is, os);
            System.out.println(os.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            FileUtils.close(is, os);
        }

    }
}
