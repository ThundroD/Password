package password;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;



public class Password {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create while loop and stopper variable and declare variable to concatenate long string
		boolean correct = false;
		String passwords = "";
		while(correct == false) {
			//create file, PrintWriter, scanner
			File save;
			PrintWriter writer;
			Scanner input = new Scanner(System.in);
			//Get passwords
			System.out.println("Please enter a password, it must include a number.");
			String password1 = input.nextLine();		
			System.out.println("Please re-enter your password");
			String password2 = input.nextLine();
			
			passwords += password1 + "\n" + password2 + "\n";

			//if statements to check if passwords are correct
			if(hasNumber(password1) == false && password1.equals(password2)) {
				System.out.println("Your first password entry doesn't contain a number. Please try again.");
			}
			else if(hasNumber(password1) == true && !password1.equals(password2)) {
				System.out.println("You're passwords are not equal. Please try again.");
			}
			else if(hasNumber(password1) == true && password1.equals(password2)) {
				System.out.println("Password confirmed!");
				correct = true;
			}
			//try catch to create and write to new file
			try {
				save = new File("passwords.txt");
				writer = new PrintWriter(save);
				writer.println(passwords);
				writer.close();
			} 
			catch(IOException e) {
				e.printStackTrace();
				System.out.println("Cannot find file");
			}
		}
	}
	//method to find if there is a number
	public static boolean hasNumber(String pass1) {
		
		int numCount = 0;
		
		for(int i = 0; i < pass1.length(); i++) {
			char num = pass1.charAt(i);
			if(isNumber(num)) {
				numCount++;
			}
		}
		//if there is at least 1 number then it returns true
		if(numCount > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	//returns if char is number
	public static boolean isNumber(char ch) {
		return (ch >= '0' && ch <= '9');
	}
}

