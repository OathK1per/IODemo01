package IO01;

import java.io.File;

public class Path {

    public static void main (String[] args) {

        /**
         * 几种path 的表示方式，推荐通过/来书写path
         */
        String path = "C:\\Learning Files\\MyCode\\IODemo01\\src\\resources\\简单问题与解决办法";
        System.out.println(path);

        System.out.println(File.separatorChar);

        path = "C:" + File.separator + "Learning Files" + File.separator + "MyCode";
        System.out.println(path);

        path = "C:/Learning Files/MyCode/IODemo01/src/resources/简单问题与解决办法";
        System.out.println(path);

        /**
         * 绝对路径和相对路径
         */
        File src = new File(path);
        System.out.println(src.getAbsolutePath());

        System.out.println(System.getProperty("user.dir"));
        src = new File("src/resources/easy.file");  // 如果第一个是/，也会从C盘开始
        System.out.println(src.getAbsolutePath());
    }
}
