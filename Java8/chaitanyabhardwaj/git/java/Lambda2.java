package chaitanyabhardwaj.git.java;

import java.util.Comparator;

public class Lambda2 {
    
    public static void main(String[] args) {
        //prior java 8
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1-i2;
            }
        };

        System.out.println(comparator.compare(3,2));

        //java 8 lambda
        Comparator<Integer> comparator1 = (i1,i2) -> i1-i2;
        System.out.println(comparator1.compare(3, 2));

    }

}
