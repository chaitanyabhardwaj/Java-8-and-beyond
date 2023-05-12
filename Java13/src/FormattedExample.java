public class FormattedExample {
    
    public static void main(String[] args) {
        var multiline = """
                There once was a ship that put to %s
                The name of the ship was the %s
                The winds blew hard dipped down her %s
                Blow my %s boys blow
                %s
                """.formatted("sea","Billy O\' Tea", "bow", "bully", "Ha!");
        System.out.println(multiline);
    }

}
