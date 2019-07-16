package IO02;

import java.io.File;

public class CountFilesLen {

    public static void main(String[] args) {
        File src = new File("C:/Learning Files/MyCode/IODemo01/src/resources/简单问题与解决办法");
        long num = count(src);
        System.out.println(num);
    }

    private static long count(File root) {
        if (root == null) {
            return 0;
        }
        if (root.isFile()) {
            return root.length();
        }
        // num = 0 只统计file个数。 num = 1 统计file加directory， 包括root dir
        long num = 0;
        for (File file : root.listFiles()) {
            long fileNum = count(file);
            num += fileNum;
        }
        return num;
    }
}
