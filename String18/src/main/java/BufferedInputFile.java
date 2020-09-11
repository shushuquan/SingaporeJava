import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liujq
 * @version 1.0.0
 * @description
 * @date 2020/9/7 22:12
 */
class BufferedInputFile1 {
    public static String read(String filename) {
        try (BufferedReader in = new BufferedReader(
                new FileReader(filename))) {
//            return in.lines()
//                    .collect(Collectors.joining("\n"));

            Collector<CharSequence, ?, String> joining = Collectors.joining("\n");
            Stream<String> lines = in.lines();
            return lines.collect(joining);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.print(
                read("FileOutputShortcut.java"));
    }
}
