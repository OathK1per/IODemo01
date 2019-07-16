package IO06;

import java.io.*;

public class FileUtils {

    /**
     * 使用FileUtils来操作IO流，能够适应不同的源和流
     * @param is
     * @param os
     */
    public static void copy(InputStream is, OutputStream os) {
        try {
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close(Closeable... ios) {
        for (Closeable io : ios) {
            if (io != null) {
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
