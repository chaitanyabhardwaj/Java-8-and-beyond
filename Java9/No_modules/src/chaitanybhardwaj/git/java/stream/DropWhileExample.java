package chaitanybhardwaj.git.java.stream;

import java.util.List;
import java.util.stream.Collectors;

public class DropWhileExample {
    
    public static void main(String args[]) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream()
            .dropWhile(n -> n < 6)
            .peek(n -> System.out.println("Number -> " + n))
            .collect(Collectors.toList());
        //dropWhile is a short circuting function which starts the stream when the predicate argument returns false
        //hence, number 6 was the first to be processed since it fails the condition n < 6
    }

}
