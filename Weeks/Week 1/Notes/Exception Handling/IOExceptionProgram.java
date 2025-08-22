class IOExceptionProgram{
    public static void main(String args[]){
         try{
            java.io.File file = new java.io.File ("notes.txt");
            java.util.Scanner input = new java.util.Scanner (file);
        }
        catch(java.io.IOException e){
            System.out.println(e.toString());
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}