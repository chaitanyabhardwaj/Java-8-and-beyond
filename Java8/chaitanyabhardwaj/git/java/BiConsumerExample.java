package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class BiConsumerExample {

    public static void main(String[] args) {
        
        //defining consumers
        Consumer<Guitar> printModel = g -> System.out.println(g.getModel());
        Consumer<Guitar> printPrice = g -> System.out.println(g.getPrice());
        Consumer<GuitarStore> printStoreName = gs -> System.out.println(gs.getStoreName());

        //defining bi consumer
        BiConsumer<GuitarStore, Guitar> containsGuitar = (gs, g) -> System.out.println(gs.containsGuitar(g));

        //initializing guitar
        Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);

        //initializing guitarStore
        List<Guitar> list = new ArrayList<>();
        list.add(g1);
        //list.add(g2);
        list.add(g3);
        GuitarStore gStore = new GuitarStore("Venus",list);

        containsGuitar.accept(gStore, g3);
        containsGuitar.accept(gStore, g2);
    }

}