javac -p mods --module-source-path "./*/" -d out --module module2
jar -cf mods/module2.jar --main-class chaitanyabhardwaj.git.java.frontend.GuitarStoreFrontend -C out/chaitanyabhardwaj.git.java.frontend/ .
jar -cf mods/module1.jar -C out/chaitanyabhardwaj.git.java/ .
java -p mods --module module2