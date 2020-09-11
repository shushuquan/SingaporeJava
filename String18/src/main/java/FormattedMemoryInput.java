import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @author liujq
 * @version 1.0.0
 * @description
 * @date 2020/9/7 21:37
 */
public class FormattedMemoryInput {
    public static void main(String[] args) {
        try (
                DataInputStream in = new DataInputStream(
                        new ByteArrayInputStream(
                                BufferedInputFile.read(
                                        "dos.txt")
                                        .getBytes()))
        ) {
            while (true)
                System.out.write((char) in.readByte());
        } catch (EOFException e) {
            System.out.println("\nEnd of stream");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
