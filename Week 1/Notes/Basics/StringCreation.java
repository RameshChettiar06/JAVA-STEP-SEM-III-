/*In Java, a String is an object that represents a sequence of characters. Unlike primitive data
types, Strings are reference types and are immutable (cannot be changed after creation).*/


public class StringCreation{
    public static void main(String args[]){
        /*1.String Literal Stored in String Pool where strings 
        are stored and variables refer to it*/
        String name = "STEP Programming";

        //2.String object
        String original = "Hello";
        String newword = original.concat(" World!");

        //3.new Keyword
        String str = new String("Hello World!");
        String copy = new String(str);

        //4.Character Array
        char charArray[] = {'J', 'a', 'v', 'a'};
        String string = new String(charArray);
        //PARTIAL ARRAY:String(charArray,startIndex,lastIndex);
        String partial = new String(charArray,0,3);
        
        
        //5.StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(" ").append("World!");
        String result = sb.toString();
        
        System.out.println(name);
        System.out.println(original);
        System.out.println(newword);
        System.out.println(str);
        System.out.println(copy);
        System.out.println(string);
        System.out.println(partial);
        System.out.println(sb);
        System.out.println(result);
       
    }
}