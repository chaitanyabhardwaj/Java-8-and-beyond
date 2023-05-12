public class SwitchExpressionExample {
    
    public static void main(String[] args) {
        var guitar = "Cort";
        var price = switch(guitar.toLowerCase()) {
            case "gibson" -> 700;
            case "fender" -> 600;
            case "epiphone" -> 500;
            case "cort" -> {
                System.out.println("Oh yeah!");
                yield 550;
            }
            default -> 0;
        };
        System.out.println(price);
    }

}
