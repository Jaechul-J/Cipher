import java.util.Scanner;

public class CaesarCipher {

	// base(97) is used in 2 methods below to convert from character to integer and
	// vice versa.
	static final int BASE = (int) 'a';

	/**
	 * Converts a character into a corresponding integer ranging from 0 to 25.
	 * 
	 * @param ch A character that will be type-cast to int.
	 * @return A corresponding integer of the lower-case ch ranging from 0~25.
	 */
	public static int char2Int(char ch) {
		int cc = ch - BASE; // Computed character ranges 0-25 (a-z)
		return cc;
	}

	/**
	 * Converts an integer into a corresponding character ranging from a-z.
	 * 
	 * @param n An integer that will be type-cast to char.
	 * @return A corresponding lower-case character of the n(0~25) + base(97).
	 */
	public static char int2Char(int n) {
		char ch = (char) (n + BASE);
		return ch;
	}

	/**
	 * Performs the modulo operation on a shifted letter.
	 * 
	 * @param n An ASCII code integer
	 * @return Returns a value between 0 and 25. If n > 25, returns the remainder
	 *         after dividing by 26. If n is negative, do the same as above, but add
	 *         26 to make it positive.
	 */
	public static int modulo(int n) {
		if (n > 25)
			n = n % 26;
		else if (n < 0)
			n = (n % 26) + 26;
		return n;
	}

	/**
	 * Adds n to the ASCII number of ch, and applies modulo method to ensure the
	 * integer falls under 0~25. Then, using type-cast to char, it returns the
	 * corresponding lower-case character.
	 * 
	 * @param ch A lower-case character that will be shifted.
	 * @param n  A number that increases ch by.
	 * @return An encrypted character by applying +n to ch.
	 */
	public static char encrypt(char ch, int n) {
		int myChar1 = char2Int(ch) + n;
		myChar1 = modulo(myChar1);
		char myChar2 = int2Char(myChar1);
		return myChar2;
	}

	/**
	 * Subtracts n from the ASCII number of ch, and applies modulo method to ensure
	 * the integer falls under 0~25. Then, using type-cast to char, it returns the
	 * corresponding lower-case character.
	 * 
	 * @param ch A lower-case character that will be shifted.
	 * @param n  A number that decreases ch by.
	 * @return A decrypted character by applying -n to ch.
	 */
	public static char decrypt(char ch, int n) {
		int myChar1 = char2Int(ch) - n;
		myChar1 = modulo(myChar1);
		char myChar2 = int2Char(myChar1);
		return myChar2;
	}
	
	/*
	 * Welcome to CaesarCipherTester class. 
	 * Here, you can see encryption or decryption of message(s) given that you follow the rules listed below.
	 * First, you will be asked to type either "encode" or "decode". 
	 * Any other input you type in will exit the program.
	 * Second, you will be asked to provide a string. Notice that you only want to type in lowercase characters.
	 * The code is implemented in a way that any input other than lowercase characters will not properly be encrypted or decrypted.
	 * Once you succeed typing in the message, you will see 26 different versions, each encrypted or decrypted by 0~25.
	 * Enjoy!
	 */
	public static void main(String[] args) {
		
		System.out.println("$ java CaesarCipher");
		System.out.println("This program encrypts and decrypts messages using the Caesar Cipher.");
		System.out.print("Would you like to encode or decode a message? ");
		Scanner obj = new Scanner(System.in);
		String input = obj.nextLine();

		if (input.equals("encode")) {
			System.out.print("Enter the string to encode: ");
			Scanner enc = new Scanner(System.in);
			String s = enc.nextLine();
			char[] arr = s.toCharArray(); //Creates a character array that contains the characters of the message typed in.

			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < s.length(); j++) {
					if(s.charAt(j) >= 'a' && s.charAt(j) <= 'z') // Make sure that only lowercase chars get encrypted
					arr[j] = encrypt(s.charAt(j), i); // 
				}
				String eString = new String(arr);
				String ind = String.format("%d", i);
				System.out.println("n = " + ind + ": " + eString);
			}
		} else if (input.equals("decode")) {
			System.out.print("Enter the string to decode: ");
			Scanner enc = new Scanner(System.in);
			String s = enc.nextLine();
			char[] arr = s.toCharArray();

			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < s.length(); j++) {
					if(s.charAt(j) >= 'a' && s.charAt(j) <= 'z') // Make sure that only lowercase chars get encrypted
					arr[j] = decrypt(s.charAt(j), i);
				}
				String eString = new String(arr);
				String ind = String.format("%d", i);
				System.out.println("n = " + ind + ": " + eString);
			}
		} 
		else
			System.err.println("Valid options are \"encode\" or \"decode\"");
	}
}