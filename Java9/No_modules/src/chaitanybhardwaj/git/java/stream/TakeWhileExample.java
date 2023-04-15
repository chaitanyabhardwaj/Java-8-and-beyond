package chaitanybhardwaj.git.java.stream;

import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileExample {
    
    public static void main(String args[]) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream()
            .peek(n -> System.out.println("Number -> " + n))
            .takeWhile(n -> n < 6)
            .collect(Collectors.toList());
        //takeWhile is a short circuting function which stops the stream when the predicate argument returns false
        //hence, number 6 was processed but since it returned false for the condition n < 6, rest of the numbers were not
    }

}
