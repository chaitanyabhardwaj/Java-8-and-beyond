package chaitanyabhardwaj.git.java;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Functional1 {
    
    public static void main(String[] args) {

        Consumer<String> consumer = (s) -> System.out.println(s.toUpperCase());
        consumer.accept("Hello World!");

        //defining consumers
        Consumer<Guitar> printModel = g -> System.out.println(g.getModel());
        Consumer<Guitar> printPrice = g -> System.out.println(g.getPrice());
        Consumer<GuitarStore> printStoreName = gs -> System.out.println(gs.getStoreName());

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

        printModel.accept(g1);
        printPrice.accept(g1);
        printModel.accept(g2);
        printPrice.accept(g2);
        printModel.accept(g3);
        printPrice.accept(g3);

        System.out.println("=====================");

        printStoreName.accept(gStore);
        gStore.geGuitars().forEach(printModel.andThen(printPrice)); // consumer chaining
    }

    static class Guitar {

        private float price;
        private String model;

        public Guitar(String model, float price) {
            this.model = model;
            this.price = price;
        }

        public String getModel() { return this.model; }

        public float getPrice() { return this.price; }

    }

    static class GuitarStore {

        private String storeName;
        private List<Guitar> modelList;

        public GuitarStore(String storeName, List<Guitar> modelList) {
            this.storeName = storeName;
            this.modelList = modelList;
        }

        public void addItem(Guitar guitar) { modelList.add(guitar); }

        public String getStoreName() { return this.storeName; }

        public boolean containsGuitar(Guitar guitar) { return modelList.contains(guitar); }

        public List<Guitar> geGuitars() { return modelList; }

    }

}
