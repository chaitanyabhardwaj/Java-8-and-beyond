javac -d target/classes chaitanyabhardwaj/git/java/module/ModuleAppExample.java \
chaitanyabhardwaj/git/java/GuitarStore.java \
chaitanyabhardwaj/git/java/module/ModuleAppExample1.java

jar -c -f target/moduleapp1.jar -C target/classes/ .

rm -r target/classes

java -cp target/moduleapp1.jar chaitanyabhardwaj.git.java.module.ModuleAppExample1