package chaitanybhardwaj.git.java;

public class PrivateMethodInterfaceMain implements PrivateMethodInterface {
    
    public static void main(String[] args) {
        PrivateMethodInterface obj = new PrivateMethodInterfaceMain();
        String str = "Hello Java9! Java9 includes the concept of private methods inside an interface. Private methods can be used in an interface in Java9.";
        System.out.println(obj.countUniqueWords(str));
        obj.printUniqueWords(str);
        //obj.listUniqueWords(str);
        //cannot call the above method because it's private. Uncomment to find out.
    }

}
