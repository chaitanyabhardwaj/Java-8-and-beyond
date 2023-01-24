package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class ConsumerPredicateExample {

    public static void main(String[] args) {
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

        //defining Predicate
        Predicate<Guitar> guitarAvailable = g -> gStore.containsGuitar(g);
        Predicate<Guitar> isCheap = g -> g.getPrice() < 600;

        //defining Consumer
        BiConsumer<Predicate<Guitar>, Guitar> printPredicateResult = (p,g) -> System.out.println(p.test(g));
        printPredicateResult.accept(guitarAvailable, g3);
        printPredicateResult.accept(isCheap, g1);
        printPredicateResult.accept(guitarAvailable.negate(), g2);
    }

}
