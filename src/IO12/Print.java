package IO12;

import java.io.*;

public class Print {
    public static void main(String[] args) throws FileNotFoundException {
        // System.out是一个打印流
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);

        PrintStream ps1 = new PrintStream(
                new BufferedOutputStream(new FileOutputStream("src/resources/print.txt")), true);
        ps1.println("打印流");
        ps1.println(true);
        ps1.println(33);

    }
}
