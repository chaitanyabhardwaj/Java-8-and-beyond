package chaitanyabhardwaj.git.java.module;

import java.util.List;
import java.util.logging.Logger;

import chaitanyabhardwaj.git.java.GuitarStore;
import chaitanyabhardwaj.git.java.GuitarStore.Guitar;

public class ModuleAppExample1 {

    final private static Logger LOGGER = Logger.getLogger(ModuleAppExample1.class.getName());

    public static void main(String[] args) {
        Guitar g1 = new Guitar("Epiphone", 500f);
        Guitar g2 = new Guitar("Fender", 600f);
        Guitar g3 = new Guitar("Gibson", 700f);

        //List.of is a static factory method introduced in java 9
        //Along with many others.
        final List<Guitar> guitarList = List.of(g1,g2,g3);

        GuitarStore gStore = new GuitarStore("Venus", guitarList);
        LOGGER.info("Class name " + ModuleAppExample1.class.getName());
        gStore.getGuitarList().forEach(System.out::println);
    }

}
