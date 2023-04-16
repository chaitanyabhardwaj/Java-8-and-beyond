package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class LocalVariableTypeInference {
    
    //private var a = 10;
    //var is not allowed here

    public static void main(String[] args) {
        /*
        String guitar = "Cort";
        int price = 750;
        char c = 'a';
        Object obj = new Object();
        List<String> list = new ArrayList<>();
        List list1 = new ArrayList<>();
        */
        //local variables can be inferenced
        var guitar = "Cort"; //String
        var price = 750; //int
        var c = 'a'; //char
        var obj = new Object(); //Object
        var list = new ArrayList<String>(); //ArrayList of Strings
        var list1 = new ArrayList<>(); //ArrayList of Objects

        var list2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); //List of int
        //var can be used in a for loop as index
        for(var n : list2) System.out.println(n);
        for(var i = 1; i <= 10; i++) System.out.println(i);

        //var can be used in a try-with-resources parameter
        try (var sc = new Scanner(System.in)) {
            System.out.print("First name: ");
            sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //var can be used as an output to a method
        var sum = sum(10,20);
    }

    /*
    public static var foo(var bar) {
        //empty function
    }
    */
    //var is not allowed as a method return type or a method parameter

    public static int sum(int a, int b) {
        return a + b;
    }

}
