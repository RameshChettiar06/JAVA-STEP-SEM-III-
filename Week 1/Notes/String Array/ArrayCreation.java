import java.util.Scanner;

public class ArrayCreation{
        public static void main(String args[]){
            Scanner input = new Scanner(System.in);
            String greetings[] = {"Hello","World","Java"};
            String colors[] = new String[3];
            colors[0] = "red";
            colors[1] = "blue";
            colors[2] = "green";

           

            for (int i = 0; i < 3; i++){
                System.out.println("greetings[" + i + "]-->"+greetings[i]);   
            }

            for (int i = 0; i < 3; i++){
             System.out.println("colors[" + i + "]-->"+colors[i]);   
            }

            input.close();
        }
}