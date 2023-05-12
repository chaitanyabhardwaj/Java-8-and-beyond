public class StripIndentExample {
    
    public static void main(String[] args) {
        var obj = ""
                +"    {\n"
                +"        \"name\" : \"Jojo\",\n"
                +"        \"gender\" : \"Female\",\n"
                +"        \"country\" : \"Japan\"\n"
                +"    }";
        System.out.println(obj);
        System.out.println(obj.stripIndent());
        // stripIndent does not work in text blocks
    }

}
