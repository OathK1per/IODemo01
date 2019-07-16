package IO08;

import java.io.*;

/**
 * 缓冲字符流，有自己实现的方法方便使用ReadLine(), newLine()
 */
public class BufferedRWCopy {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        copy();
        long time1 = System.currentTimeMillis();
        System.out.println(time1 - time);
    }

    private static void copy() {
        File source = new File("src/resources/summary");
        File dest = new File("src/resources/dest5.txt");


        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {
            String str = null;
            while ((str = br.readLine()) != null) {
                bw.write(str, 0, str.length());
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
