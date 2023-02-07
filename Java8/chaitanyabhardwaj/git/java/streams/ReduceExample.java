package chaitanyabhardwaj.git.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class ReduceExample {

    public static void main(String[] args) {
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

        //using reduce method to sum price of all guitars
        Optional<Float> priceSum = gStore.geGuitars().stream()
        .map(Guitar::getPrice)
        .reduce((p1,p2) -> p1 + p2);

        if(priceSum.isPresent())
            System.out.println(priceSum.get());

        //using reduce method to find reduce the stream to the highest priced guitar
        Optional<Guitar> highestPrice = gStore.geGuitars().stream()
            .reduce((gu1,gu2) -> (gu1.getPrice() > gu2.getPrice())?gu1:gu2);

        if(highestPrice.isPresent())
            System.out.println(highestPrice.get());
    }
    
}
