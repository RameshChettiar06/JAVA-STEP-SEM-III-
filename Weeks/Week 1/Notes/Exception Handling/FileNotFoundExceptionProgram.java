class FileNotFoundExceptionProgram{
    public static void main(String args[]){
        try{
            java.io.File file = new java.io.File ("abcd.txt");
            java.util.Scanner input = new java.util.Scanner (file);
        }
        catch(java.io.FileNotFoundException e){
            System.out.println(e.toString());
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

       
    }
}