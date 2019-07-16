package IO08;

import IO06.FileUtils;

import java.io.*;
import java.util.Date;

public class VideoCopy {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        copy();
        long time1 = System.currentTimeMillis();
        System.out.println(time1 - time);
    }

    public static void copy() {

        File source = new File("src/resources/181_IO_字节缓冲流.mp4");
        File dest = new File("src/resources/181_IO_字节缓冲流_copy.mp4");

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            FileUtils.copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            FileUtils.close(is, os);
        }

    }
}
