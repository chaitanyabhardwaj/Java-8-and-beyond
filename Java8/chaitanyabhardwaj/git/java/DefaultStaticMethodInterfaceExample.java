package chaitanyabhardwaj.git.java;

@FunctionalInterface
public interface DefaultStaticMethodInterfaceExample {
    
    public int multiply(int a, int b);

    public default double toDouble(int a) {
        System.out.println("Original default method called!");
        return (double)a;
    }

    public static double power(int a, int b) {
        System.out.println("Static method called which can't be overriden");
        return Math.pow(a,b);
    }

}
