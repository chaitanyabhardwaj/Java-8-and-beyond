package chaitanyabhardwaj.git.java.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class CountDistinctSortedExample {
    
    public static void main(String args[]) {
        //initializing guitar
        Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);

        //initializing guitarStore
        List<Guitar> list = new ArrayList<>();
        list.add(g2);
        list.add(g2);
        list.add(g1);
        GuitarStore gStore1 = new GuitarStore("Venus",list);
        list = new ArrayList<>();
        list.add(g3);
        list.add(g1);
        list.add(g3);
        GuitarStore gStore2 = new GuitarStore("Venus",list);

        //creating a 'single' list of all guitars available in all stores
        List<List<Guitar>> guitarMasterList = new ArrayList<>();
        guitarMasterList.add(gStore1.geGuitars());
        guitarMasterList.add(gStore2.geGuitars());

        //flatting the list using FlatMap
        //using distinct to eliminate duplicate elements
        //using sorted to get a sorted stream of guitars
        List<String> guitarListFlattend = guitarMasterList.stream()
            //input -> Stream<List<Guitars>>
            //output -> Stream<Guitars>
            .flatMap(List::stream)
            .map(Guitar::getModel)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        
        guitarListFlattend.forEach(System.out::println);

        //using count to count the number of guitars
        System.out.println(guitarListFlattend.stream().count());

        //sorted using comparator based on price
        List<Guitar> guitarListFlattend1 = guitarMasterList.stream()
            //input -> Stream<List<Guitars>>
            //output -> Stream<Guitars>
            .flatMap(List::stream)
            .distinct()
            .sorted(Comparator.comparing(Guitar::getPrice))
            .collect(Collectors.toList());
        
        guitarListFlattend1.forEach(System.out::println);

        //sorted using comparator based on price high to low
        guitarListFlattend1 = guitarMasterList.stream()
            //input -> Stream<List<Guitars>>
            //output -> Stream<Guitars>
            .flatMap(List::stream)
            .distinct()
            .sorted(Comparator.comparing(Guitar::getPrice).reversed())
            .collect(Collectors.toList());
        
        guitarListFlattend1.forEach(System.out::println);
    }

}
