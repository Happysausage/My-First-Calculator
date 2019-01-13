import java.util.*;
import java.util.Scanner;
//@author Antti Narvaez Recio
//@version 1.0

public class Calculator{
    //every program starts with main method
    public static void main(String[] args) {
        Boolean repeat = true;
        //if the number of command line arguments is 3, use them for the calculation, otherwise wait for user input
        if (args.length == 3) {
            System.out.println(calculator(args));
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Input a binary operation: ");
            System.out.println(calculator(input.nextLine().split("\\s+")));
        }
    }

    //calculator method that takes string arguments and returns the calculation
    private static double calculator(String[] args) {
        //if there are not 3 arguments, give an error message
        if (args.length != 3) {
            throw new IllegalArgumentException("This calculator only accepts binary operations!");
        }
        //parse arguments to appropriate form
        double n1 = Double.parseDouble(args[0]);
        char operator = args[1].charAt(0);
        double n2 = Double.parseDouble(args[2]);

        //case where user tried to divide by zero
        if (n2 == 0 && (operator == '/' || operator == '%')) {
            throw new IllegalArgumentException("Can't divide by zero!");
        }
        return calculation(n1, operator, n2);
    }

    //calculation method
    private static double calculation(double n1, char operator, double n2) {
        double answer = 0;
        switch(operator) {
            //calculation depending on the operator between the input numbers
            case '+':
                answer = n1 + n2;
            break;
            case '-':
                answer = n1 - n2;
            break;
            case '*':
                answer = n1 * n2;
            break;
            case '/':
                answer = n1 / n2;
            break;
            case '%':
                answer = n1 % n2;
            break;
            case '^':
                answer = Math.pow(n1, n2);
            break;
        }
        return answer;
    }
}