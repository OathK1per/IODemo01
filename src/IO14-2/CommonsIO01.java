package IO14;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CommonsIO01 {
    /**
     * 大小
     */
    private static void sizeOf() {
        long size1 = FileUtils.sizeOf(new File("src/resources/dest3.txt"));
        long size2 = FileUtils.sizeOf(new File("src/resources"));
        System.out.println(size1);
        System.out.println(size2);
    }
    /**
     * 列出文件
     */
    private static void listFile() {
        Collection<File> files =
                FileUtils.listFiles(new File("src/resources"),
                        EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("--------------------------");

        files = FileUtils.listFiles(new File("src/resources"),
                FileFilterUtils.or(new SuffixFileFilter("txt"), new SuffixFileFilter("html")),
                DirectoryFileFilter.INSTANCE);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("--------------------------");
    }

    /**
     * 读取文件
     */
    private static void read() throws IOException {
        String msg = FileUtils.readFileToString(new File("src/resources/dest5.txt"), "UTF-8");
        System.out.println(msg);
        System.out.println("--------------------------");
        byte[] bytes = FileUtils.readFileToByteArray(new File("src/resources/dest5.txt"));
        System.out.println(bytes.length);
        System.out.println("--------------------------");
        List<String> lines = FileUtils.readLines(new File("src/resources/dest2.txt"), "UTF-8");
        for (String str : lines) {
            System.out.println(str);
        }
        System.out.println("--------------------------");
        LineIterator iterator = FileUtils.lineIterator(new File("src/resources/dest2.txt"), "UTF-8");
        while (iterator.hasNext()) {
            System.out.println(iterator.nextLine());
        }
    }

    /**
     * 写入文件
     */
    private static void write() throws IOException {
        FileUtils.write(new File("src/resources/dest6.txt"),
                "Hello\r\nWorld\r\n", "UTF-8", true);
        FileUtils.writeStringToFile(new File("src/resources/dest6.txt"),
                "Hello\r\nWorld\r\n", "UTF-8", true);
        FileUtils.writeByteArrayToFile(new File("src/resources/dest6.txt"),
                "Hello\r\nWorld".getBytes("UTF-8"),true);
        List<String> data = new ArrayList<>();
        data.add("Nobody");
        data.add("Complicated");
        data.add("Tomorrow");
        FileUtils.writeLines(new File("src/resources/dest6.txt"), data, "-->", true);
    }

    public static void main(String[] args) throws IOException {
        write();
    }
}
