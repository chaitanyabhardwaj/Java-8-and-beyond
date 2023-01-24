package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class PredicateExample {

    public static void main(String args[]) {
        //initializing guitar
        Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);

        //initializing GuitarStore
        List<Guitar> list = new ArrayList<>();
        list.add(g1);
        //list.add(g2);
        list.add(g3);
        GuitarStore gStore = new GuitarStore("Venus",list);
        
        //defining predicate
        Predicate<Guitar> guitarAvailable = g -> gStore.containsGuitar(g);
        Predicate<Guitar> isCheap = g -> g.getPrice() < 600;

        System.out.println(guitarAvailable.test(g1));
        System.out.println(guitarAvailable.and(isCheap).test(g1));
        System.out.println(guitarAvailable.and(isCheap).negate().test(g3));
        System.out.println(guitarAvailable.or(isCheap).test(g3));
        System.out.println(guitarAvailable.negate().or(isCheap).test(g2));
    }

}