javac -d target/classes chaitanyabhardwaj/git/java/module/ModuleAppExample.java \
module-info.java \
chaitanyabhardwaj/git/java/GuitarStore.java \
chaitanyabhardwaj/git/java/module/ModuleAppExample1.java

jar -c -f target/moduleapp1.jar --main-class chaitanyabhardwaj.git.java.module.ModuleAppExample \
-C target/classes/ .

rm -r target/classes

java -p target --module chaitanyabhardwaj.git.java.module