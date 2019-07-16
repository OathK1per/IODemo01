package IO03;

import java.io.*;

public class Read {

    public static void main(String[] args) {
        // 1.创建源
        File file = new File("src/resources/简单问题与解决办法");
        // 2.选择流
        FileInputStream is = null;

        {
            try {
                // 3.操作(读取)数据
                is = new FileInputStream(file);
                int temp;
                // 处理is.read()时将发生读取事件
                while ((temp = is.read()) != -1) {
                    System.out.println((char)temp);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 4.释放资源
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
