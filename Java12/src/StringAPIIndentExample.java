public class StringAPIIndentExample {
    
    public static void main(String[] args) {
        var wellerman = "There once was a ship that put to sea\n" +
                  "The name of the ship was the Billy O' Tea\n" +
                  "The winds blew up, her bow dipped down\n" +
                  "Oh blow, my bully boys, blow (huh)";
        System.out.println("Before indentation\n" + wellerman);
        System.out.println("After indentation\n" + wellerman.indent(4));
    }

}
