package shu.edu.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liujq
 * @version 1.0.0
 * @description
 * @date 2020/9/12 14:29
 */
public class FileToWordsRegexp {
    private String all;
    public FileToWordsRegexp(String filePath) throws Exception {
        all = Files.lines(Paths.get(filePath))
                .skip(1) // First (comment) line
                .collect(Collectors.joining(" "));
    }
    public Stream<String> stream() {
        return Pattern
                .compile("[ .,?]+").splitAsStream(all);
    }
    public static void
    main(String[] args) throws Exception {
/*        FileToWordsRegexp fw = new FileToWordsRegexp("Cheese.dat");
        fw.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
        fw.stream()
                .skip(7)
                .limit(2)
                .map(w -> w + " ")
                .forEach(System.out::print);*/

        String str = "wo ai,ni?zhong.guo";
        Pattern.compile("[ .,?]+").splitAsStream(str).map(w -> w + " ").forEach(System.out::print);
    }
}
