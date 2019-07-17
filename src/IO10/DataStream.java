package IO10;

import java.io.*;

/**
 * 数据流，能够处理流中传递的数据，是一种装饰流，
 * 一般顺序是先写入，后读取
 * 读取顺序需与写入顺序一致
 * 建议均在流上加入缓冲流
 */
public class DataStream {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
        dos.writeUTF("没有cc哈哈");
        dos.writeBoolean(true);
        dos.writeInt(13);
        dos.flush();
        byte[] bytes = os.toByteArray();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(bytes)));
        String s = dis.readUTF();
        boolean b = dis.readBoolean();
        int i = dis.readInt();
        System.out.println(s + " " + b + " " + i);
    }
}
