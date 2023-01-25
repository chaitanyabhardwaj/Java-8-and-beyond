package chaitanyabhardwaj.git.java;

import java.util.function.Function;

public class FunctionExample {
    
    public static void main(String args[]) {
        //defining function
        Function<String, Integer> str2Int = str -> Integer.parseInt(str);
        Function<String, String> removeWhiteSpaces = str -> str.replaceAll(" ", "");
        Function<Integer, Boolean> isPrime = n -> {
            int sq = (int)Math.sqrt(n);
            for(int i = 2; i <= sq; i++) {
                if(n % i == 0) return false;
            }
            return true;
        };
        //chain : removeWhiteSpaces -> str2Int -> isPrime
        System.out.println(removeWhiteSpaces.andThen(str2Int).andThen(isPrime).apply("1  09 "));
        //chain :  [str2Int <- removeWhiteSpaces] -> isPrime
        System.out.println(str2Int.compose(removeWhiteSpaces).andThen(isPrime).apply(" 1 2  7 "));
    }

}
