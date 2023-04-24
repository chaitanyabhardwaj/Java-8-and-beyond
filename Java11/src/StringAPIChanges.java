import java.util.Arrays;

public class StringAPIChanges {
    
    public static void main(String[] args) {
        //repeat method
        var str = "ABC";
        System.out.println(str.repeat(3));
        System.out.println(str.repeat(0));

        //isBlank method
        var str1 = "     ";
        System.out.println(str1.isEmpty());
        System.out.println(str1.isBlank());//considers whitespace while deciding if it's blank

        //strip methos
        var str2 = "  Hello World   \u2001";
        System.out.println(str2.trim().length());
        System.out.println(str2.strip().length());//covers newly added unicode whitespaces

        //stripTrailing method
        System.out.println(str2.stripTrailing().length());
        //stripLeading method
        System.out.println(str2.stripLeading().length());

        //lines method
        var multilineStr = "Gibson\nEpiphone\nCort\nFender";

        //split before JDK 8
        var lines1 = multilineStr.split(System.lineSeparator());
        for(String s : lines1)
            System.out.println(s);

        //split after JDK 8
        var lines2 = multilineStr.split("\\R");
        Arrays.stream(lines2).forEach(System.out::println);
        
        //split after JDK 11
        multilineStr.lines().forEach(System.out::println);
    }

}
