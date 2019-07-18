package IO13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess3 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/resources/dest5.txt");
        // 总长度
        long total = file.length();
        // 每块大小
        int blockSize = 1024;
        // 分多少块
        int size = (int) Math.ceil(total * 1.0 / blockSize);
        // 起始位置和实际大小
        int beginPos = 0;
        int actualSize;
        for (int i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) {
                actualSize = (int)total;
            } else {
                actualSize = blockSize;
                total -= actualSize;
            }
            System.out.println(i + "-->" + beginPos + "-->" + actualSize);
            random(i, beginPos, actualSize, file);
        }
    }

    private static void random(int i, int beginPos, int actualSize, File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        RandomAccessFile raf2 = new RandomAccessFile(new File("src/resources/copy-" + i + ".txt"), "rw");
        raf.seek(beginPos);
        byte[] bytes = new byte[512];
        int len;
        while ((len = raf.read(bytes)) != -1) {
            if (actualSize > len) {
//                System.out.println(new String(bytes, 0, len));
                raf2.write(bytes, 0, len);
                actualSize -= len;
            } else {
//                System.out.println(new String(bytes, 0, actualSize));
                raf2.write(bytes, 0, actualSize);
                break;
            }
        }

        raf.close();
    }
}
