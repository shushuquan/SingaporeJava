import java.io.*;

/**
 * @author liujq
 * @version 1.0.0
 * @description
 * @date 2020/9/7 20:58
 */
public class FileOutputShortcut {
    static String file = "FileOutputShortcut.dat";

    public static void main(String[] args) {
        try (
                BufferedReader in = new BufferedReader(
                        new StringReader(BufferedInputFile.read(
                                "FileOutputShortcut.java")));
                // Here's the shortcut:
                PrintWriter out = new PrintWriter(file)
        ) {
            in.lines().forEach(out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
/*        try {
            System.out.println(BufferedInputFile.read(file));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


}


class BufferedInputFile {
    // Throw exceptions to console:
    public static String
    read(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while((s = in.readLine())!= null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }
/*    public static void main(String[] args)
            throws IOException {
        System.out.print(read("BufferedInputFile.java"));
    }*/
} /* (Execute to see output) *///:~