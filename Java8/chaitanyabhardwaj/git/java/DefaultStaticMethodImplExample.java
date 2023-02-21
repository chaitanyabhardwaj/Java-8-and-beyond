package chaitanyabhardwaj.git.java;

public class DefaultStaticMethodImplExample implements DefaultStaticMethodInterfaceExample {

    @Override
    public int multiply(int a, int b) {
        return a*b;
    }
    
    @Override
    public double toDouble(int a) {
        System.out.println("Overriden default method called!");
        return a/1.0;
    }

    public static void main(String[] args) {
        DefaultStaticMethodInterfaceExample dsmie1 = new DefaultStaticMethodImplExample();
        DefaultStaticMethodInterfaceExample dsmie2 = new DefaultStaticMethodImpl();
        int mul = dsmie1.multiply(3, 2);
        System.out.println(mul);
        double d1 = dsmie2.toDouble(mul);
        System.out.println(d1);
        double d2 = dsmie1.toDouble(mul);
        System.out.println(d2);
        double pow = DefaultStaticMethodInterfaceExample.power(3, 2);
        System.out.println(pow);
    }

    public static class DefaultStaticMethodImpl implements DefaultStaticMethodInterfaceExample {

        @Override
        public int multiply(int a, int b) {
            return a*b;
        }

    }


}
