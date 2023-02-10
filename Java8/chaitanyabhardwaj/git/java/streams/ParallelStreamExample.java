package chaitanyabhardwaj.git.java.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import chaitanyabhardwaj.git.java.streams.OfIterateGenerateExample.ShellGuitar;

public class ParallelStreamExample {
    
    public static void main(String args[]) {
        //no. of processors available in this machine
        System.out.println("Number of processors: " + Runtime.getRuntime().availableProcessors());
        //no. of threads created by streams api = no. of processors available in a machine

        long start = System.currentTimeMillis();
        generateShellGuitarsSeq(500);
        long end = System.currentTimeMillis() - start;
        System.out.println("Time taken sequentially to generate ShellGuitar: " + end + "ms");
        start = System.currentTimeMillis();
        generateShellGuitarsPara(500);
        end = System.currentTimeMillis() - start;
        System.out.println("Time taken parallely to generate ShellGuitar: " + end + "ms");
        //over here time taken by seq > time taken by parallel stream

        start = System.currentTimeMillis();
        generateShellGuitarsSeq(10000000);
        end = System.currentTimeMillis() - start;
        System.out.println("Time taken sequentially to generate ShellGuitar: " + end + "ms");
        start = System.currentTimeMillis();
        generateShellGuitarsPara(10000000);
        end = System.currentTimeMillis() - start;
        System.out.println("Time taken parallely to generate ShellGuitar: " + end + "ms");
        //over here time taken by parallel > time taken by seq stream

        //summation using seq stream
        long sum = IntStream.rangeClosed(0, 1000000)
            .sum();
        System.out.println(sum);
        //summation using parallel stream
        sum = IntStream.rangeClosed(0, 1000000)
            .parallel()
            .sum();
        System.out.println(sum);
    }

    public static List<ShellGuitar> generateShellGuitarsSeq(long n) {
        return Stream.generate(ShellGuitar::new)
            .limit(n)
            .collect(Collectors.toList());
    }

    public static List<ShellGuitar> generateShellGuitarsPara(long n) {
        return Stream.generate(ShellGuitar::new)
            .parallel()
            .limit(n)
            .collect(Collectors.toList());
    }

}
