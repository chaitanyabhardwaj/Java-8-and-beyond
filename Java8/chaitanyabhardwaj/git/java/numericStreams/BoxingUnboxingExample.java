package chaitanyabhardwaj.git.java.numericStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnboxingExample {
    
    public static void main(String args[]) {
        //boxing using boxed method
        List<Integer> list = IntStream.range(1, 10)
            .boxed()
            .collect(Collectors.toList());
        list.forEach(System.out::println);

        //unboxing using mapToInt method
        int sum = list.stream()
            .mapToInt(i -> i)
            .sum();
        System.out.println(sum);

        //unboxing using mapToLong method
        long sum1 = list.stream()
            .mapToLong(i -> i)
            .sum();
        System.out.println(sum1);

        //unboxing using mapToLong method
        double sum2 = list.stream()
            .mapToDouble(i -> i)
            .sum();
        System.out.println(sum2);

        //unboxing using mapToObject method
        IntStream.range(1, 10)
            .mapToObj(i -> i + " ").forEach(System.out::print);
    }

}
