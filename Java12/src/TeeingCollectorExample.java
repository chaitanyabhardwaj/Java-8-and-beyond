import java.util.List;
import java.util.stream.Collectors;

public class TeeingCollectorExample {
    
    public static void main(String[] args) {
        var numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        var str = numbers.stream()
                    .collect(Collectors.teeing(
                        Collectors.joining(" "),
                        Collectors.counting(),
                        (R1, R2) -> R1 + " | sum = " +R2));
        System.out.println(str);// 1 2 3 4 5 6 7 8 9 10 | sum = 10
    }

}
