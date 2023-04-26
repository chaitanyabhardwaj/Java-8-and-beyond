import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesAPIChanges {
    
    public static void main(String[] args) {
        try {
            //write to a file
            Files.writeString(Paths.get("./sample.txt"), "Hello World!");
            //read a file
            var content = Files.readString(Paths.get("./sample.txt"));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
