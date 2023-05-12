import java.util.List;
import java.util.stream.Collectors;

public class TranslateEscapeExample {
    
    public static void main(String[] args) {
        var listOfStrings = List.of("Hello!\n", "It\'s me\n", "I was wondering", "if after all these years you\'d like to meet.");
        System.out.println(listOfStrings); //shows escape characters
        var translated = listOfStrings.stream()
                                      .map(String::translateEscapes)
                                      .collect(Collectors.toList());
        System.out.println(translated); //translated escape characters
    }

}
