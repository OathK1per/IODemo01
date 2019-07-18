package IO13;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("src/resources/dest5.txt"), "r");
        //起始位置
        int beginPos = 10;
        //实际大小
        int actualSize = 1026;
        raf.seek(beginPos);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = raf.read(bytes)) != -1) {
            if (actualSize > len) {
                System.out.println(new String(bytes, 0, len));
                actualSize -= len;
            } else {
                System.out.println(new String(bytes, 0, actualSize));
                break;
            }
        }

        raf.close();
    }
}
