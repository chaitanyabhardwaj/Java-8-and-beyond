package chaitanyabhardwaj.git.java.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class TerminalOperationsExample {

    public static void main(String args[]) {
        //initializing guitar
        Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);
        Guitar g4 = new Guitar("Epiphone", 540);
        Guitar g5 = new Guitar("Fender", 650);
        Guitar g6 = new Guitar("Gibson", 720);

        //initializing guitarStore
        List<Guitar> list = new ArrayList<>();
        list.add(g1);
        list.add(g2);
        list.add(g3);
        list.add(g4);
        list.add(g5);
        list.add(g6);
        GuitarStore gStore = new GuitarStore("Venus",list);
        
        //joining method example1
        String guitarListStr = gStore.geGuitars().stream()
            .map(Guitar::getModel)
            .collect(Collectors.joining());
        System.out.println(guitarListStr);
        //joining method example2
        String guitarListStr1 = gStore.geGuitars().stream()
            .map(Guitar::getModel)
            .collect(Collectors.joining(" | "));
        System.out.println(guitarListStr1);

        //counting method example1
        long guitarListCount = gStore.geGuitars().stream()
            .collect(Collectors.counting());
        System.out.println(guitarListCount);
        //counting method example2
        long guitarListCount1 = gStore.geGuitars().stream()
            .filter(g -> g.getPrice() < 650)
            .collect(Collectors.counting());
        System.out.println(guitarListCount1);

        //mapping method example1
        List<String> guitarList = gStore.geGuitars().stream()
            .collect(Collectors.mapping(Guitar::getModel, Collectors.toList()));
        System.out.println(guitarList);
        //mapping method example2
        Set<String> guitarSet = gStore.geGuitars().stream()
            .collect(Collectors.mapping(Guitar::getModel, Collectors.toSet()));
        System.out.println(guitarSet);

        //minBy method example
        Optional<Guitar> cheapestGuitar = gStore.geGuitars().stream()
            .collect(Collectors.minBy(Comparator.comparing(Guitar::getPrice)));
        if(cheapestGuitar.isPresent())
            System.out.println(cheapestGuitar.get());
        //maxBy method example
        Optional<Guitar>  costliestGuitar = gStore.geGuitars().stream()
            .collect(Collectors.maxBy(Comparator.comparing(Guitar::getPrice)));
        if(costliestGuitar.isPresent())
            System.out.println(costliestGuitar.get());

        //summingint method example
        int guitarPriceSumInt = gStore.geGuitars().stream()
            .collect(Collectors.summingInt(g -> (int)g.getPrice()));
        System.out.println(guitarPriceSumInt);
        //averagingint method example
        double guitarPriceAvgInt = gStore.geGuitars().stream()
            .collect(Collectors.averagingInt(g -> (int)g.getPrice()));
        System.out.println(guitarPriceAvgInt);

        //summingdouble method example
        double guitarPriceSumDouble = gStore.geGuitars().stream()
            .collect(Collectors.summingDouble(Guitar::getPrice));
        System.out.println(guitarPriceSumDouble);
        //averagingdouble method example
        double guitarPriceAvgDouble = gStore.geGuitars().stream()
            .collect(Collectors.averagingDouble(Guitar::getPrice));
        System.out.println(guitarPriceAvgDouble);
        
        //groupingby method example1
        Map<String, List<Guitar>> guitarGroup = gStore.geGuitars().stream()
            .collect(Collectors.groupingBy(Guitar::getModel));
        System.out.println(guitarGroup);
        //groupingby method example2
        Map<String, List<Guitar>> guitarGroup1 = gStore.geGuitars().stream()
            .collect(Collectors.groupingBy(g -> (g.getPrice() < 650)?"InExpensive":"Expensive"));
        System.out.println(guitarGroup1);
        //groupingby method example3[multi lvl groupingby]
        Map<String, Map<String, List<Guitar>>> guitarGroup2 = gStore.geGuitars().stream()
            .collect(Collectors
            .groupingBy(Guitar::getModel, Collectors
            .groupingBy(g -> (g.getPrice() < 650)?"InExpensive":"Expensive")));
        System.out.println(guitarGroup2);
        //groupingby method example4
        LinkedHashMap<String, Set<Guitar>> guitarGroup3 = gStore.geGuitars().stream()
            .collect(Collectors.groupingBy(Guitar::getModel, LinkedHashMap::new, Collectors.toSet()));
        System.out.println(guitarGroup3);

        //partitioningby method example1
        Map<Boolean, List<Guitar>> guitarPartition = gStore.geGuitars().stream()
            .collect(Collectors.partitioningBy(g -> g.getPrice() < 650));
        System.out.println(guitarPartition);
        //partitioningby method example2
        Map<Boolean, Set<Guitar>> guitarPartition1 = gStore.geGuitars().stream()
            .collect(Collectors.partitioningBy(g -> g.getPrice() < 650, Collectors.toSet()));
        System.out.println(guitarPartition1);
    }
    
}
