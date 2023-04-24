import java.util.function.Predicate;

public class LocalVariableInLambdaParameter {
    
    public static void main(String args[]) {
        //Before JDK 11
        Predicate<Integer> isEven1 = (Integer p) -> p % 2 == 0;
        Predicate<Integer> isEven2 = p -> p % 2 == 0;

        //After JDK 11
        Predicate<Integer> isEven3 = (var p) -> p % 2 == 0;

        System.out.println(isEven1.test(10));
        System.out.println(isEven2.test(10));
        System.out.println(isEven3.test(10));
    }

}
