package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class BinaryOperatorExample {

    public static void main(String args[]) {
        //defining BinaryOperator
        BinaryOperator<Guitar> mergeGuitar = (g1,g2) -> new Guitar(g1.getModel() + g2.getModel(), g1.getPrice() + g2.getPrice());
        //defining Comparator
        Comparator<Guitar> compareGuitars = (g1, g2) -> (int)(g1.getPrice() - g2.getPrice());
        BinaryOperator<Guitar> maxBuy = BinaryOperator.maxBy(compareGuitars);
        BinaryOperator<Guitar> minBuy = BinaryOperator.minBy(compareGuitars);
        
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
        Consumer<Guitar> printModel = g -> System.out.println(g.getModel() + " -> " + g.getPrice());

        gStore.addItem(mergeGuitar.apply(g3, g2));
        gStore.addItem(mergeGuitar.apply(maxBuy.apply(g2, g3), g1));
        gStore.addItem(mergeGuitar.apply(minBuy.apply(g2, g3), g1));
        gStore.geGuitars().forEach(printModel);
    }

}