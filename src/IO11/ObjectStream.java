package IO11;

import java.io.*;
import java.util.Date;

/**
 * 对象流，可处理各种数据与对象，是一种装饰流
 * 先写出后读取
 * 读取顺序与写入顺序一致
 * 需要保证对象是可序列化的
 */
public class ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.writeObject(new Date());
        oos.writeObject(new Student(213, "ama"));
        oos.flush();
        byte[] bytes = baos.toByteArray();
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(bytes)));
        Object object = ois.readObject();
        Object student = ois.readObject();
        if (object instanceof Date) {
            System.out.println(object);
        }
        if (student instanceof Student) {
            System.out.println(student.toString());
        }
    }
}

class Student implements Serializable {
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}