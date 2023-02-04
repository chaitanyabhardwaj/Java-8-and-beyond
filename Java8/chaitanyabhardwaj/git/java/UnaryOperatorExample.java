package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class UnaryOperatorExample {

    public static void main(String args[]) {
        //defining unary operator
        UnaryOperator<Guitar> cloneGuitar = g -> new Guitar(g.getModel(), g.getPrice());

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

        //defining consumer
        Consumer<Guitar> printModel = g -> System.out.println(g.getModel());

        gStore.addItem(cloneGuitar.apply(g2));
        gStore.geGuitars().forEach(printModel);
    }

}