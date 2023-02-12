package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;

public class DefaultMethodExample {
    
    public static void main(String args[]) {
        //initializing guitar
        Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);
        Guitar g4 = new Guitar("Epiphone", 540);
        Guitar g5 = new Guitar("Fender", 650);
        Guitar g6 = new Guitar("Gibson", 720);

        //initializing guitarStore
        List<Guitar> list = new ArrayList<>();
        list.add(g1);
        list.add(g2);
        list.add(g3);
        list.add(g4);
        list.add(g5);
        list.add(g6);
        
        //sorting a list
        //prior to java 8
        Collections.sort(list);
        System.out.println(list);
        //java 8, using default method introduced in List interface
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        //java 8, using default method introduced in List interface, in reverse order
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        //java 8, using default method introduced in List interface, sorting with custom comparator
        Comparator<Guitar> priceComparator = Comparator.comparingDouble(Guitar::getPrice);
        list.sort(priceComparator);
        System.out.println(list);
        //java 8, using default method introduced in List interface, sorting with custom comparator, reversed
        list.sort(priceComparator.reversed());
        System.out.println(list);
        //java 8, using default method introduced in List interface, sorting with custom comparator, null value
        list.add(null);
        Comparator<Guitar> nullComparator1 = Comparator.nullsFirst(priceComparator);
        list.sort(nullComparator1);
        System.out.println(list);
        Comparator<Guitar> nullComparator2 = Comparator.nullsLast(priceComparator);
        list.sort(nullComparator2);
        System.out.println(list);
    }

}
