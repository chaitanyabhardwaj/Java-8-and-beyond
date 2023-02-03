package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;
import chaitanyabhardwaj.git.java.ConsumerExample1.GuitarStore;

public class BiFunctionExample {

    public static void main(String args[]) {
        //defining BiFunction
        BiFunction<GuitarStore, GuitarStore, GuitarStore> hasMoreGuitars =
        (gs1,gs2) -> (gs1.geGuitars().size() > gs2.geGuitars().size())?gs1:gs2;
        BiFunction<GuitarStore, Float, List<Guitar>> getGuitarsUnderPrice = (gs, p) -> {
            List<Guitar> l = gs.geGuitars().stream().filter(g -> g.getPrice() <= p).collect(Collectors.toList());
            return l;
        };

        //defining a Fuction
        Function<GuitarStore, Guitar> cheapestGuitar = gs -> {
            Guitar gg = null;
            float min = Integer.MAX_VALUE;
            for(Guitar g : gs.geGuitars()) {
                if(g.getPrice() < min) {
                    min = g.getPrice();
                    gg = g;
                }
            }
            return gg;
        };

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
        list = new ArrayList<>();
        list.add(g1);
        list.add(g2);
        list.add(g3);
        list.add(g1);
        GuitarStore gStore1 = new GuitarStore("Pluto",list);

        //defining consumer
        Consumer<Guitar> printModel = g -> System.out.println(g.getModel());

        System.out.println(hasMoreGuitars.apply(gStore, gStore1).getStoreName());
        getGuitarsUnderPrice.apply(gStore, 650f).forEach(printModel);
        hasMoreGuitars.andThen(cheapestGuitar).andThen(g -> {printModel.accept(g); return null;}).apply(gStore, gStore1);
    }

}