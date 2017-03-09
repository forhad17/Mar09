package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculate {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
	try{	
		System.out.println("Please enter the first number");
		int num1 = k.nextInt();
		
		System.out.println("Please enter the second number");
		int num2 = k.nextInt();
		
		System.out.println("Result of Division of "+ num1+ " with "+num2+ " = "+ num1/num2 );
	}
	catch(ArithmeticException e){
		System.out.println("Please do not enter zero");
	}
	catch(InputMismatchException e){
		System.out.println("Please enter integer values only");
	}
	catch(Exception e){
		System.out.println("Please enter a valid input");
	}
	}
}
