package chaitanyabhardwaj.git.java.steams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class MapExample {
    
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

        //using map to collect guitar models
        List<String> guitarModels = gStore.geGuitars().stream()
            //input -> Guitar
            //output -> String(model)
            .map(Guitar::getModel)
            .collect(Collectors.toList());

        guitarModels.forEach(System.out::println);
        
    }

}
