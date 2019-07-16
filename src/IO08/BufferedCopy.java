package IO08;

import java.io.*;
import java.util.Date;

/**
 * 缓冲字节流
 */
public class BufferedCopy {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        copy();
        long time1 = System.currentTimeMillis();
        System.out.println(time1 - time);
    }

    private static void copy() {
        File source = new File("src/resources/181_IO_字节缓冲流.mp4");
        File dest = new File("src/resources/181_IO_字节缓冲流_copy.mp4");

        try (InputStream is = new BufferedInputStream(new FileInputStream(source));
             OutputStream os = new BufferedOutputStream(new FileOutputStream(dest))) {

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
        }
    }
}
