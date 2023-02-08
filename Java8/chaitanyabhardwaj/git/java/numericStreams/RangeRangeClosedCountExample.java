package chaitanyabhardwaj.git.java.numericStreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class RangeRangeClosedCountExample {
    
    public static void main(String args[]) {
        //definig an IntStream with range [1-9]
        IntStream intStream = IntStream.range(1, 10);
        //counting the number of elements in stream
        System.out.println(intStream.count());
        //printing an IntStream with range [1-9]
        IntStream.range(1, 10).forEach(System.out::println);
        //printing an IntStream with range [1-10]
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
        //printing an LongStream with range [1-10]
        LongStream.rangeClosed(1, 10).forEach(System.out::println);
        //printing an IntStream converted to DoubleStream with range [1-10]
        IntStream.rangeClosed(1, 10).asDoubleStream().forEach(System.out::println);
    }

}
