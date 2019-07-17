package IO13;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class SplitFile {
    //源路径
    private File source;
    //目的文件夹
    private String destDir;
    //每个文件的路径
    private List<String> destPaths;
    //每个文件的大小
    private int blockSize;
    //总长度
    private long total;
    //总块数
    private int size;

    public SplitFile(File source, String destDir, int blockSize) {
        this.source = source;
        this.destDir = destDir;
        this.destPaths = new ArrayList<>();
        this.blockSize = blockSize;
        init();
    }

    private void init() {
        this.total = source.length();
        // 分多少块
        this.size = (int) Math.ceil(total * 1.0 / blockSize);
        for (int i = 0; i < size; i++) {
            destPaths.add(this.destDir + "/" + this.blockSize + "-" + i + ".txt");
        }
    }

    public void split() throws IOException {

        // 起始位置和实际大小
        int beginPos = 0;
        int actualSize;
        int i;
        for (i = 0; i < size; i++) {
            beginPos = i * blockSize;
            if (i == size - 1) {
                actualSize = (int)total;
            } else {
                actualSize = blockSize;
                total -= actualSize;
            }

            splitDetail(i, beginPos, actualSize);
        }
    }

    private void splitDetail(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.source, "r");
        RandomAccessFile raf2 = new RandomAccessFile(new File(destPaths.get(i)), "rw");
        raf.seek(beginPos);
        byte[] bytes = new byte[blockSize];
        int len;
        while ((len = raf.read(bytes)) != -1) {
            if (actualSize > len) {
                raf2.write(bytes, 0, len);
                actualSize -= len;
            } else {
                raf2.write(bytes, 0, actualSize);
                break;
            }
        }

        raf.close();
    }
    public static void main(String[] args) throws IOException {
        SplitFile sf = new SplitFile(new File("src/resources/dest5.txt"), "src/resources", 1024);
        sf.split();
    }
}
