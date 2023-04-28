import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringAPITransformExample {
    
    public static void main(String[] args) {
        var wellerman = "There once was a ship that put to sea\n" +
        "The name of the ship was the Billy O' Tea\n" +
        "The winds blew up, her bow dipped down\n" +
        "Oh blow, my bully boys, blow (huh)";

        Function<String, String> reverseWordsInLine = s -> {
            var lines = s.lines();
            var lineOfWords = lines.map(l -> l.split("[\s+\\.,]")).collect(Collectors.toList());
            var newLines = new ArrayList<String>();
            var str = "";
            for(var line : lineOfWords) {
                str = "";
                for(var word : line)
                    str = word + " " + str;
                newLines.add(str.strip());
            }
            return newLines.stream().collect(Collectors.joining("\n"));
        };

        var NAMRELLEW = wellerman.transform(String::toUpperCase).transform(reverseWordsInLine);
        System.out.println(NAMRELLEW);
    }

}
