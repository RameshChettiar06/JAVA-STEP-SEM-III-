/*Problem 5: Write a program to analyze and format structured data from
CSV-like text input using string manipulation methods
Hint =>
a. Take user input for CSV-like data (comma-separated values in multiple lines)
b. Create a method to parse CSV data without using split():
● i. Use charAt() to identify commas and newlines
● ii. Extract each field using substring() method
● iii. Handle quoted fields that may contain commas
● iv. Store data in a 2D array structure
c. Create a method to validate and clean data:
● i. Remove leading/trailing spaces from each field
● ii. Validate numeric fields using ASCII values
● iii. Check for missing or invalid data
● iv. Apply data type conversions where needed
d. Create a method to perform data analysis:
● i. Calculate column statistics (min, max, average for numeric columns)
● ii. Count unique values in categorical columns
● iii. Identify data quality issues (missing, invalid entries)
e. Create a method using StringBuilder to format output:
● i. Create aligned tabular display with fixed column widths
● ii. Add borders and headers for better readability
● iii. Format numeric values with proper decimal places
● iv. Highlight data quality issues
f. Create a method to generate data summary report:
● i. Show total records processed
● ii. Display column-wise statistics
● iii. List data quality findings
● iv. Calculate data completeness percentage
g. The main function processes CSV input and generates formatted output with analysis report */
import java.util.Scanner;

public class CustomCSVFormatter{
    public static boolean validateExpression(String expr){
        int balance=0;
        char prev=' ';

        for(int i=0; i<expr.length(); i++){
            char ch=expr.charAt(i);

            if(!(ch>='0' && ch<='9') && ch!='+' && ch!='-' && ch!='*' && ch!='/' && ch!='(' && ch!=')' && ch!=' '){
                return false;
            }

            if(ch=='(')  balance++;
            if(ch==')')  balance--;

            if((ch=='+' || ch=='-' || ch=='*' || ch=='/') && (prev=='+' || prev=='-' || prev=='*' || prev=='/')){
                return false;
            }

            if(balance<0)  return false;
            prev=ch;
        }
        return balance==0;
    }

    public static int evaluateExpression(String expr, StringBuilder steps){
        while(expr.contains("(")){
            int close=expr.indexOf(")");
            int open=expr.lastIndexOf("(",close);
            String inside=expr.substring(open + 1, close);
            int val=evaluateExpression(inside,steps);
            expr=expr.substring(0, open)+val+expr.substring(close+1);
            steps.append("Evaluate (").append(inside).append(") → ").append(val).append("\n");
        }

        int[] numbers=new int[100];
        char[] operators=new char[100];
        int nIndex=0, oIndex=0;

        for(int i=0; i<expr.length(); ){
            char ch=expr.charAt(i);
            if(ch==' '){
                i++;
                continue;
            }
            if(ch>='0' && ch<='9'){
                int j=i;

                while(j<expr.length() && expr.charAt(j)>='0' && expr.charAt(j)<='9') j++;
                numbers[nIndex++]=Integer.parseInt(expr.substring(i,j));
                i=j;
            }
            else{
                operators[oIndex++]=ch;
                i++;
            }
        }

        for(int i=0; i<oIndex; i++){
            if(operators[i]=='*' || operators[i]=='/'){
                int result=(operators[i]=='*') ? numbers[i]*numbers[i+1] : numbers[i]/numbers[i+1];
                steps.append(numbers[i]).append(" ").append(operators[i]).append(" ").append(numbers[i+1]).append(" = ").append(result).append("\n");

                numbers[i]=result;
                for(int j=i+1; j<nIndex-1; j++)  numbers[j]=numbers[j+1];
                for(int j=i; j<oIndex-1; j++)  operators[j]=operators[j+1];
                nIndex--;
                oIndex--;
                i--;
            }
        }

        int result=numbers[0];
        int k=1;
        for(int i=0; i<oIndex; i++){
            if(operators[i]=='+'){
                steps.append(result).append(" + ").append(numbers[k]).append(" = ");
                result+=numbers[k];
                steps.append(result).append("\n");
            }
            else if(operators[i]=='-'){
                steps.append(result).append(" - ").append(numbers[k]).append(" = ");
                result-=numbers[k];
                steps.append(result).append("\n");
            }
            k++;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Text-Based Calculator");
        System.out.println("=====================");
        System.out.print("Enter number of expressions: ");
        int n=input.nextInt();
        input.nextLine();

        for(int i=0; i<n; i++){
            System.out.print("\nEnter expression "+(i+1)+": ");
            String expr=input.nextLine();

            if(!validateExpression(expr)){
                System.out.println("Invalid expression format!");
                continue;
            }

            StringBuilder steps=new StringBuilder();
            steps.append("\nOriginal Expression: ").append(expr).append("\n");

            int result=evaluateExpression(expr,steps);
            steps.append("Final Result: ").append(result).append("\n");

            System.out.println("\nCalculation Steps:\n"+steps);
        }
        input.close();
    }
}