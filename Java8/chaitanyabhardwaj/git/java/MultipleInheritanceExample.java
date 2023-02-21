package chaitanyabhardwaj.git.java;

public class MultipleInheritanceExample implements MyInterface1, MyInterface2, MyInterface3{

    @Override
    public void a() {
        System.out.println("Inside method a of " + MultipleInheritanceExample.class);
    }

    /*
     * Precedence in Multiple inheritance
     * 1. Class that implements the interface
     * 2. The child(leave node) interface that extends the interface. 
     * 3. The interface itself
     */

    public static void main(String[] args) {
        MultipleInheritanceExample m1 = new MultipleInheritanceExample();
        m1.a();
        m1.b();
        m1.c();
    }

}
