package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class MethodReferenceExample {

    public static void main(String args[]) {
        //defining Function, using MethodReference
        Function<GuitarStore, List<Guitar>> getGuitars = GuitarStore::geGuitars;

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

        list = getGuitars.apply(gStore);
        list.forEach(System.out::println);
    }

}