package chaitanyabhardwaj.git.java;

import java.util.List;

public class GuitarStore {
    
    private String name;
    private List<Guitar> guitarList;
    public GuitarStore(String name, List<Guitar> guitarList) {
        this.name = name;
        this.guitarList = guitarList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Guitar> getGuitarList() {
        return guitarList;
    }

    public void setGuitarList(List<Guitar> guitarList) {
        this.guitarList = guitarList;
    }

    public static class Guitar {

        private String model;
        private float price;

        public Guitar(String model, float price) {
            this.price = price;
            this.model = model;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Guitar [model=" + model + ", price=" + price + "]";
        }

    }

}
