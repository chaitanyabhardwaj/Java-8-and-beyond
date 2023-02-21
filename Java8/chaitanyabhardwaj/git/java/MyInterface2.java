package chaitanyabhardwaj.git.java;

public interface MyInterface2 extends MyInterface1 {
    
    default void b() {
        System.out.println("Inside method b of " + MyInterface2.class);
    }

    default void a() {
        System.out.println("Inside method a of " + MyInterface2.class);
    }

}
