package chaitanyabhardwaj.git.java;

public class Lambda1 {

    public static void main(String[] args) {
        //prior to java 8
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Prior to java8");
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();

        //java 8 lambda
        Runnable runnable1 = () -> {
            System.out.println("Java 8 lambda");
        };

        //above lambda expression can also be written as:
        runnable1 = () -> System.out.println("Java 8 lambda");

        Thread thread2 = new Thread(runnable1);
        thread2.start();

        //above lambda expression can also be written as:
        new Thread(() -> System.out.println("Java 8 compacted lambda")).start();
    }

}