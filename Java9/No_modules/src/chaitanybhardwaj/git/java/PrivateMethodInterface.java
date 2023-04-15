package chaitanybhardwaj.git.java;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public interface PrivateMethodInterface {
    
    default int countUniqueWords(String str) {
        return listUniqueWords(str).size();
    }

    default void printUniqueWords(String str) {
        listUniqueWords(str).forEach(System.out::println);
    }

    private Set<String> listUniqueWords(String str) {
        str = str.trim();
        String[] words = str.split("\s*!*\\?*[\s+\\.!\\?]\s*!*\\?*");
        return Arrays.stream(words).map(String::toLowerCase).collect(Collectors.toSet());
    }

}