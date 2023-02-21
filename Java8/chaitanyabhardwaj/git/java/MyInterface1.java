package chaitanyabhardwaj.git.java;

public interface MyInterface1 {

    default void a() {
        System.out.println("Inside method a of " + MyInterface1.class);
    }

}
