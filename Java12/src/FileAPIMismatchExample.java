import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAPIMismatchExample {
    
    public static void main(String[] args) {
        var path1 = Path.of("./src/sample1.txt");
        var path2 = Path.of("./src/sample2.txt");
        var path3 = Path.of("./src/sample3.txt");

        try {
            System.out.println(Files.mismatch(path1, path2));//-1 = no mismatch
            System.out.println(Files.mismatch(path2, path1));//-1 = no mismatch
            System.out.println(Files.mismatch(path1, path3));//6 = index of the first mismatch byte
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
