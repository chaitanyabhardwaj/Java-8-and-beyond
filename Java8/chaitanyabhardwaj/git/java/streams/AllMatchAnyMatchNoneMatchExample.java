package chaitanyabhardwaj.git.java.streams;

import java.util.ArrayList;
import java.util.List;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class AllMatchAnyMatchNoneMatchExample {
    
    public static void main(String args[]) {
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

        //using allMatch to find out if all Guitars in the store are priced below or equal to 650
        boolean allMatch = gStore.geGuitars().stream()
            .allMatch(g -> g.getPrice() <= 650);
        //using anyMatch to find out if any Guitar in the store is priced below or equal to 650
        boolean anyMatch = gStore.geGuitars().stream()
            .anyMatch(g -> g.getPrice() <= 650);
        //using noneMatch to find out if no Guitar in the store is priced below or equal to 650
        boolean noneMatch = gStore.geGuitars().stream()
            .noneMatch(g -> g.getPrice() <= 650);

        System.out.println("All match -> " + allMatch);
        System.out.println("Any match -> " + anyMatch);
        System.out.println("None match -> " + noneMatch);
    }

}
