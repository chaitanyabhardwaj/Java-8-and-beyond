package chaitanyabhardwaj.git.java.numericStreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SumMaxMinAverageExample {

    public static void main(String args[]) {
        //calculating sum of elements of an IntStream[1-9] using sum method
        int sum = IntStream.range(1, 10).sum();
        System.out.println(sum);
        //calculating max value in IntStream using max mathod
        OptionalInt max = IntStream.range(1, 10).max();
        System.out.println(max.isPresent()?max.getAsInt():-1);
        //calculating min value in LongStream using max mathod
        OptionalLong min = LongStream.rangeClosed(1, 10).min();
        System.out.println(min.isPresent()?min.getAsLong():-1);
        //calculating avg value in LongStream using average mathod
        OptionalDouble avg = LongStream.rangeClosed(1, 10).average();
        System.out.println(avg.isPresent()?avg.getAsDouble():-1);
    }
    
}
