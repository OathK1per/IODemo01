package IO13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MergeFile {
    public static void main(String[] args) throws IOException {
        List<File> srcPaths = new ArrayList<>();
        for (int i = 0; i < 3; i ++) {
            srcPaths.add(new File("src/resources/1024-" + i + ".txt"));
        }
        merge("src/resources/merge.txt", srcPaths);
    }

    private static void merge(String destPath, List<File> srcPaths) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath));
        Vector<InputStream> vi = new Vector<>();
        SequenceInputStream sis = null;
        for (int i = 0; i < srcPaths.size(); i++) {
            vi.add(new BufferedInputStream(new FileInputStream(srcPaths.get(i))));
        }
        sis = new SequenceInputStream(vi.elements());
        byte[] bytes = new byte[1024];
        int len;
        while ((len = sis.read(bytes)) != -1) {
            os.write(bytes);
        }
        os.flush();
        os.close();
        sis.close();
    }
}
