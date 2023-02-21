package chaitanyabhardwaj.git.java;

public interface MyInterface3 extends MyInterface2 {
    
    default void b() {
        System.out.println("Inside method b of " + MyInterface3.class);
    }

    default void c() {
        System.out.println("Inside method c of " + MyInterface3.class);
    }

}
