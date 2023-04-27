public class SwitchExperssionPreview {
    
    public static void main(String[] args) {
        //In JDK 12, switch expression was introduced as a preview feature
        //Preview features are disabled by default in JDKs
        //To enable a switch expression preview feature run the following command in terminal
        //compile -> javac --release 12 --enable-preview SwitchExperssionPreview.java
        //run -> java --enable-preview SwitchExperssionPreview
        var guitar = "Cort";
        var price = switch(guitar) {
            case "Gibson" -> 1000;
            case "Fender" -> 750;
            case "Epiphone" -> 800;
            case "Cort" -> 700;
            default -> 500;
        };
        System.out.println(price); //700
    }

}
