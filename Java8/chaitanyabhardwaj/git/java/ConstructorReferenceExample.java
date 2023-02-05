package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class ConstructorReferenceExample {

    public static void main(String args[]) {
        //defining BiFunction, using ConstructorReference
        BiFunction<String, Float, Guitar> createGuitar = Guitar::new;
        BiFunction<String, List<Guitar>, GuitarStore> createStore = GuitarStore::new;

        //initializing guitar
        /*Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);
        */
        Guitar g1 = createGuitar.apply("Epiphone", 500f);
        Guitar g2 = createGuitar.apply("Fender", 600f);
        Guitar g3 = createGuitar.apply("Gibson", 700f);

        //initializing guitarStore
        List<Guitar> list = new ArrayList<>();
        list.add(g1);
        list.add(g2);
        list.add(g3);
        //GuitarStore gStore = new GuitarStore("Venus",list);
        GuitarStore gStore = createStore.apply("Venus", list);

        gStore.geGuitars().forEach(System.out::println);
    }

}