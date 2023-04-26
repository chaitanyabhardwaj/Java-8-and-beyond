import java.util.function.Predicate;

public class PredicateNotExample {
    
    public static void main(String[] args) {
        Predicate<String> isBlank = s -> s.isBlank();

        var str = "Hello World";

        //print string if not blank
        //method1
        if(!isBlank.test(str)) {
            System.out.println(str);
        }

        //method2
        if(isBlank.negate().test(str)) {
            System.out.println(str);
        }

        //method3
        if(Predicate.not(String::isBlank).test(str)) {
            System.out.println(str);
        }
    }

}
