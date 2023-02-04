package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class SupplierExample {

    public static void main(String args[]) {
        //defining Supplier
        Supplier<Guitar> guitarEpiphoneSupplier = () -> new Guitar("Epiphone", 500);
        Supplier<Guitar> guitarFenderSupplier = () -> new Guitar("Fender", 600);
        Supplier<Guitar> guitarGibsonSupplier = () -> new Guitar("Gibson", 700);

        //initializing guitar
        /*Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);
        */

        //initializing guitarStore
        List<Guitar> list = new ArrayList<>();
        list.add(guitarEpiphoneSupplier.get());
        list.add(guitarFenderSupplier.get());
        list.add(guitarGibsonSupplier.get());
        GuitarStore gStore = new GuitarStore("Venus",list);

        //defining consumer
        Consumer<Guitar> printModel = g -> System.out.println(g.getModel() + " -> " + g.getPrice());

        gStore.geGuitars().forEach(printModel);
    }

}