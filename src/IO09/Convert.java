package IO09;

import java.io.*;

/**
 * 通过键盘输入流
 */
public class Convert {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String str = ""; // 设成null，会报NPE的错
            while (!str.equals("quit")) {
                str = br.readLine();
                bw.write(str, 0, str.length());
                bw.newLine();
                bw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
