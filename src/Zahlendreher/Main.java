package Zahlendreher;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
	

	
	public static void main(String[] args) {

		//System.out.println("Hello Zahlendreher!");
        int userInput;
        int firstDigit, secondDigit, thirdDigit;
        //int userInput123 = 123;
        Scanner sc = new Scanner(System.in);
        System.out.print("Zahl: ");
        userInput = sc.nextInt();

        firstDigit  = (userInput%100)%10;
        secondDigit = (userInput/10)%10;
        thirdDigit = userInput/100;

        // following three lines are for monitoring/testing
        // System.out.println("first digit : " +  firstDigit);
        //System.out.println("second digit : " + secondDigit);
        // System.out.println("third digit : " + thirdDigit);

        if (userInput > 99  && userInput < 1000  )
            System.out.println(String.format("Ausgabe: %d%d%d", firstDigit, secondDigit, thirdDigit));
        else if (userInput > 9 && userInput < 100 )
            System.out.println(String.format("Ausgabe: %d%d0", firstDigit, secondDigit));
        else if (userInput < 10)
            System.out.println(String.format("Ausgabe: %d00", userInput));


	}


}
