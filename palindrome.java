package palindrome;

import java.util.Scanner; 

public class palindrome {
	
	public static void test() {
		String word, newWord, another; //variable for the word input by the user, the altered word if the tester is not case sensitive, and the indicator for whether the user wants to try the test again
		int left, right; //creates variables for pinpointing indexes in the word
		boolean caseFlag = false; //creates boolean that determines whether palindrome tester will be case sensitive
		
		Scanner scan = new Scanner(System.in); //creates Scanner object 
		
		System.out.println("\nEnter a string to evaluate for palindrome: "); //Tells user to input a word to be tested
		
		word = scan.nextLine(); //stores user input into the String object 'word'
		
		/* If the boolean caseFlag is false, it gets the word and makes all the letters lower case
		   to ensure that case sensitivity won't be a problem. It then stores this new string into
		   the String object 'newWord'. 
		   If the boolean caseFlag is true, then the value in the String object 'word' just gets 
		   directly stored into the String object 'newWord' so that case sensitivity comes into 
		   play when testing if it's a palindrome.
		 */
		
		if (caseFlag == false) {
			newWord = word.toLowerCase(); 
		} else {
			newWord = word; 
		}
		
		left = 0; //initializes the variable 'left' as 0
		right = (newWord.length() - 1); //initializes the variable 'right' as the number of characters in the user's word
		
		/* This upcoming while loop creates a check to see if the characters on the opposite sides
		 * of the word are the same. If they are the same, the 'left' and 'right' variables move
		 * one index closer to the middle of the word and check the characters at those indexes
		 * as well. It continues like this until either the characters are not equal or until the
		 * 'right' integer is no longer larger than the 'left' integer (in other words, the 'left'
		 * and 'right' index markers have checked through the entire word. 
		 */
		
		while((newWord.charAt(left) == newWord.charAt(right)) && (left < right)) {
			left++;
			right--; 
		}
		
		/* If the while loop wasn't able to make it all the way through the word, then the right int should be larger than the left. 
		 * If the while didn't make it all the way through, then the word is not the palindrome. This if statement prints out the 
		 * word and then states that it is not a palindrome. If the right int is not larger than the left, then due to the while
		 * loop the only possible choice is that they are equal, and that the while loop made it through the whole word. The else
		 * part of the if statement prints out the word and states that it is a palindrome. 
		 */
		
		if (left < right) {
			System.out.println("\n" + word + " is not a palindrome.");
		} else {
			System.out.println("\n" + word + " is a palindrome.");
		}
		
		System.out.println("\nDo you want to try again (Y or N)? "); //Prompts the user, asking them if they want to try another word
		
		another = scan.nextLine(); //stores the user's answer into the variable another
		
		/* If the another variable is equal to a Y for yes (either upper case or lower case, then it runs the test method all over again.
		 * Otherwise, it prints a closing statement and closes the scanner object. 
		 */
		
		if (another.equalsIgnoreCase("y")) {
			test();
		} else {
			System.out.println("\nThanks for playing!");
			scan.close(); 
		}
	}
	
	public static void main(String[] args) {
		
		test(); //starts the recursion method
		
	}
	
}
