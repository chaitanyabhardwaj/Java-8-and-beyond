package chaitanyabhardwaj.git.java.streams;

import java.util.stream.Stream;

import chaitanyabhardwaj.git.java.ConsumerExample1.Guitar;

public class OfIterateGenerateExample {

    public static void main(String args[]) {
        //initializing guitar
        Guitar g1 = new Guitar("Epiphone", 500);
        Guitar g2 = new Guitar("Fender", 600);
        Guitar g3 = new Guitar("Gibson", 700);
        
        //using 'of' Factory Method to create a stream
        Stream<Guitar> guitarStream = Stream.of(g1,g2,g3);
        guitarStream.forEach(System.out::println);

        //using 'iterate' Factory Method to iterate from 1 to 10
        Stream.iterate(1, i -> i + 1)
            .limit(10)
            .forEach(System.out::println);;

        //using 'generate' Factory Method to generate 5 ShellGuitar objects
        Stream.generate(ShellGuitar::new)
            .limit(5)
            .forEach(System.out::println);
    }

    public static class ShellGuitar extends Guitar {

        public ShellGuitar() {
            //ShellGuitar is an imaginary guitar with not model and no price
            super("-",0f);
        }

    }
    
}
