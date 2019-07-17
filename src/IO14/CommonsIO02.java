package IO14;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class CommonsIO02 {
    public static void main(String[] args) throws IOException {
        copy();
    }

    private static void copy() throws IOException {
//        String string = IOUtils.toString(new URL("https://www.baidu.com"), "UTF-8");
//        System.out.println(string);
        FileUtils.copyFile(new File("src/resources/source.txt"), new File("src/resources/dest10.txt"));
        FileUtils.copyFileToDirectory(new File("src/resources/source.txt"), new File("src/IO14"));
        FileUtils.copyDirectoryToDirectory(new File("src/IO13"), new File("src/IO14"));
        FileUtils.copyDirectory(new File("src/IO14"), new File("src/IO14-2"));
        FileUtils.copyURLToFile(new URL("https://www.baidu.com"), new File("src/IO14/baidu.html"));
    }
}
