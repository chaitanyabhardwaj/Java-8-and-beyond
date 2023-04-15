package chaitanybhardwaj.git.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OfNullableExample {
    
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,2,3);
        List<Integer> list2 = List.of(4,5,6);
        List<Integer> list3 = null;
        List<Integer> list4 = List.of(7,8,9,10);
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);
        listOfLists.add(list4);
        listOfLists.stream()
            .flatMap(l -> Stream.ofNullable(l))
            .forEach(System.out::println);
        //Stream ofNullable returns a stream of elements if not null else it returns an empty stream
    }

}
