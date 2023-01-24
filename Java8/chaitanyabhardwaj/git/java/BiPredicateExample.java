package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class BiPredicateExample {
    
    public static void main(String[] args) {
        //initializing guitar
        Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);

        //initializing GuitarStore
        List<Guitar> list1 = new ArrayList<>();
        List<Guitar> list2 = new ArrayList<>();
        list1.add(g1);
        list1.add(g3);
        list2.add(g2);
        list2.add(g3);
        GuitarStore gStore1 = new GuitarStore("Venus",list1);
        GuitarStore gStore2 = new GuitarStore("Venus",list2);

        //defining BiPredicate
        BiPredicate<GuitarStore, Guitar> isAvailableInStore = (gs, g) -> gs.containsGuitar(g);
        
        System.out.println(isAvailableInStore.test(gStore1, g1));
        System.out.println(isAvailableInStore.test(gStore2, g2));
    }

}
