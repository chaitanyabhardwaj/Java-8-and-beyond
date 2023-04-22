package chaitanyabhardwaj.git.java;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OrElseThrowExample {
    
    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> max = list.stream().max(Comparator.naturalOrder());

        //Deprecated version
        if(max.isPresent())
            System.out.println(max.get());

        //New version introduced in Java10
        System.out.println(max.orElseThrow());
    }

}
