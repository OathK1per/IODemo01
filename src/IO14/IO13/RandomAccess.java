package IO13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("src/resources/dest5.txt"), "r");
        raf.seek(10);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = raf.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        raf.close();
    }
}
