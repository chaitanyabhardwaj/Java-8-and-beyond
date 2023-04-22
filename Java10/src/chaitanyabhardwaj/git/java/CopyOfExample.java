package chaitanyabhardwaj.git.java;

import java.util.ArrayList;
import java.util.List;

public class CopyOfExample {
    
    public static void main(String args[]) {
        var modifiableList = new ArrayList<Integer>();
        modifiableList.add(1);
        modifiableList.add(2);
        modifiableList.add(3);
        modifiableList.add(4);
        modifiableList.add(5);
        //create an unmodifiable collection using of method
        //this adds modifiableList as the first element in unmodifiableList1
        var unmodifiableList1 = List.of(modifiableList);
        modifiableList.add(6);
        //create an unmodifiable collection using copyOf method
        //this creates a new unmodifiable list which clones the elements of modifiableList.
        //This is not a reflection of modifiableList i.e. changes in modifiableList will not be reflected here
        var unmodifiableList2 = List.copyOf(modifiableList);
        modifiableList.add(7);
        System.out.println(unmodifiableList1);
        System.out.println(unmodifiableList2);
    }

}
