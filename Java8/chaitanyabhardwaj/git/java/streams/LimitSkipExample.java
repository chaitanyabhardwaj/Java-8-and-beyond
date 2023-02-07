package chaitanyabhardwaj.git.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class LimitSkipExample {
    
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
        list.add(g2);
        list.add(g1);
        GuitarStore gStore = new GuitarStore("Venus",list);

        //calculating the highest priced guitar among first 3 guitars using Limit method
        Optional<Guitar> expensiveGuitar1 = gStore.geGuitars().stream()
            //limits the stream to first 3 elements
            //this creates a sub stream
            .limit(3)
            .reduce((gu1,gu2) -> (gu1.getPrice() > gu2.getPrice())?gu1:gu2);
        
        //calculating the lowest priced guitar among last 3 guitars using Skip method
        Optional<Guitar> expensiveGuitar2 = gStore.geGuitars().stream()
            //skips first 2 elements of the stream
            //this creates a sub stream
            .skip(2)
            .reduce((gu1,gu2) -> (gu1.getPrice() < gu2.getPrice())?gu1:gu2);

        if(expensiveGuitar1.isPresent())
            System.out.println(expensiveGuitar1.get());
        if(expensiveGuitar2.isPresent())
            System.out.println(expensiveGuitar2.get());
    }

}
