/* Problem 3: Write a program to implement a text-based data compression
algorithm using character frequency and StringBuilder
Hint =>
a. Take user input for text to compress
b. Create a method to count character frequency without using HashMap:
● i. Create arrays to store characters and their frequencies
● ii. Use charAt() to iterate through text
● iii. Count occurrences of each unique character
● iv. Return parallel arrays of characters and frequencies
c. Create a method to create compression codes using StringBuilder:
● i. Assign shorter codes to more frequent characters
● ii. Use numbers/symbols for common characters
● iii. Create a mapping table of original character to code
● iv. Return the mapping as a 2D array
d. Create a method to compress text using the generated codes:
● i. Replace each character with its corresponding code
● ii. Use StringBuilder for efficient string building
● iii. Calculate compression ratio (original size vs compressed size)
e. Create a method to decompress the text:
● i. Reverse the compression process using the mapping table
● ii. Validate that decompression returns original text
f. Create a method to display compression analysis:
● i. Show character frequency table
● ii. Display compression mapping
● iii. Show original text, compressed text, decompressed text
● iv. Calculate and display compression efficiency percentage
g. The main function performs compression, decompression, and displays complete analysis*/
import java.util.Scanner;

public class CustomTextCompressionAlgorithm{
    public static Object[] countFrequencies(String text){
        char[] uniqueChars=new char[text.length()];
        int[] freq=new int[text.length()];
        int uniqueCount=0;

        for(int i=0; i<text.length(); i++){
            char c=text.charAt(i);
            boolean found=false;

            for(int j=0; j<uniqueCount; j++){
                if(uniqueChars[j]==c){
                    freq[j]++;
                    found=true;
                    break;
                }
            }
            if(!found){
                uniqueChars[uniqueCount]=c;
                freq[uniqueCount]=1;
                uniqueCount++;
            }
        }

        char[] chars=new char[uniqueCount];
        int[] frequencies=new int[uniqueCount];
        System.arraycopy(uniqueChars, 0, chars, 0, uniqueCount);
        System.arraycopy(freq, 0, frequencies, 0, uniqueCount);

        return new Object[]{chars,frequencies};
    }

    public static String[][] generateCodes(char[] chars, int[] freq){
        int n=chars.length;
        String[][] mapping=new String[n][2];

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(freq[j]>freq[i]){
                    int tmpF=freq[i];  freq[i]=freq[j];  freq[j]=tmpF;
                    char tmpC=chars[i];  chars[i]=chars[j];  chars[j]=tmpC;
                }
            }
        }

        for(int i=0; i<n; i++){
            mapping[i][0]=String.valueOf(chars[i]);
            mapping[i][1]=Integer.toString(i);
        }
        return mapping;
    }

    public static String compressText(String text, String[][] mapping){
        StringBuilder compressed=new StringBuilder();

        for(int i=0; i<text.length(); i++){
            String c=String.valueOf(text.charAt(i));

            for(String[] map : mapping){
                if(map[0].equals(c)){
                    compressed.append(map[1]).append(" ");
                    break;
                }
            }
        }
        return compressed.toString().trim();
    }

    public static String decompressText(String compressed, String[][] mapping){
        StringBuilder decompressed=new StringBuilder();
        String[] codes=compressed.split(" ");
    
        for(String code : codes){
            for(String[] map : mapping){
                if(map[1].equals(code)){
                    decompressed.append(map[0]);
                    break;
                }
            }
        }
        return decompressed.toString();
    }

    public static void displayFrequencies(char[] chars, int[] freq){
        System.out.println("\nCharacter Frequency Table:");
        System.out.println("Char\tFrequency");
        for(int i=0; i<chars.length; i++){
            System.out.println(chars[i]+"\t"+freq[i]);
        }
    }

    public static void displayMapping(String[][] mapping){
        System.out.println("\nCompression Mapping:");
        System.out.println("Char\tCode");
        for(String[] map : mapping){
            System.out.println(map[0]+"\t"+map[1]);
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter text to compress: ");
        String text=input.nextLine();

        Object[] result=countFrequencies(text);
        char[] chars=(char[])result[0];
        int[] freq=(int[])result[1];

        String[][] mapping=generateCodes(chars,freq);

        String compressed=compressText(text,mapping);

        String decompressed=decompressText(compressed,mapping);

        displayFrequencies(chars,freq);
        displayMapping(mapping);

        System.out.println("\nOriginal Text: "+text);
        System.out.println("Compressed Text: "+compressed);
        System.out.println("Decompressed Text: "+decompressed);

        int originalSize=text.length();
        int compressedSize=compressed.length();
        double efficiency=(1-(double)compressedSize/originalSize)*100;
        System.out.printf("\nCompression Ratio: %.2f%% efficiency\n", efficiency);

        if(text.equals(decompressed)){
            System.out.println("Decompression successful: Original text restored");
        }
        else{
            System.out.println("Decompression failed: Text mismatch");
        }
        input.close();
    }
}