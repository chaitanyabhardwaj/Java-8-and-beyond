package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class StreamExample {
    
    public static void main(String args[]) {
        //initializing guitar
        Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);

        //initializing guitarStore
        List<Guitar> list = new ArrayList<>();
        list.add(g1);
        list.add(g2);
        list.add(g3);
        GuitarStore gStore = new GuitarStore("Venus",list);

        //print all guitars in gStore using stream
        gStore.geGuitars().stream().forEach(System.out::println);
        //filter guitars using price and print using stream
        gStore.geGuitars().stream()
        .filter(g -> g.getPrice() < 650)
        .forEach(System.out::println);
        //create a map of guitars using stream
        Map<String, Float> guitarMap = gStore.geGuitars().stream()
        .collect(Collectors.toMap(Guitar::getModel,Guitar::getPrice));
        System.out.println(guitarMap);
        
        //peek method
        //this stream pipeline won't run since peek is an intermediate operation
        gStore.geGuitars().stream().peek(System.out::println);
        //this stream pipeline will run since collect is a terminal operation
        gStore.geGuitars().stream().peek(System.out::println).collect(Collectors.toList());
    }

}
