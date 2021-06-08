package pa1;

import java.util.Scanner;

public class VigenereCipher {

	static int base = (int) 'a';

	/*
	 * Same comments as in CaesarCipher
	 */
	public static int char2Int(char ch) {
		int cc = ch - base;
		return cc;
	}

	/*
	 * Same comments as in CaesarCipher
	 */
	public static char int2Char(int n) {
		char ch = (char) (n + base);
		return ch;
	}

	/*
	 * Same comments as in CaesarCipher
	 */
	public static int modulo(int n) {
		if (n > 25)
			n = n % 26;
		else if (n < 0)
			n = (n % 26) + 26;
		return n;
	}

	/**
	 * StringBuilder object will append each character from key repeatedly until it
	 * reaches the length of txt.
	 * 
	 * @param txt A message that will be encrypted or decrypted on
	 * @param key A string that will be replicated up to the length of txt.
	 * @return Returns a replication of key that is the length of txt.
	 */
	public static String replicate(String txt, String key) {

		StringBuilder keyString = new StringBuilder();

		// Iterates through the length of txt to append character for keyString.
		for (int i = 0, j = 0; i < txt.length(); i++) {
			if (j < key.length()) {
				keyString.append(key.charAt(j)); // Appends each character in key until it reaches the end.
				j++;
			} else {
				j = 0;
				keyString.append(key.charAt(j)); // After reaching the end of key, else statement is executed to fill
													// the rest of keyString.
				j++;
			}
		}
		return keyString.toString();
	}

	/*
	 * Same comments as in CaesarCipher
	 */
	public static char encrypt(char ch, int n) {
		int myChar1 = char2Int(ch) + n;
		myChar1 = modulo(myChar1);
		char myChar2 = int2Char(myChar1);
		return myChar2;
	}

	/*
	 * Same comments as in CaesarCipher
	 */
	public static char decrypt(char ch, int n) {
		int myChar1 = char2Int(ch) - n;
		myChar1 = modulo(myChar1);
		char myChar2 = int2Char(myChar1);
		return myChar2;
	}

	/*
	 * Welcome to VigenereCipherTester class. Here, you can see encryption or
	 * decryption of plainText by the keyword you provide. First, you will be asked
	 * to type either "encode" or "decode". Any other input you type in will exit
	 * the program. Second, you will be asked to provide a string. Notice that you
	 * must type in lowercase characters. The code is implemented in a way that any
	 * input other than lowercase characters will not properly be encrypted or
	 * decrypted. Once you succeed typing in the message, you will be asked to
	 * provide the key. Each characters in the key will be extended to the length of
	 * your plainText, and will be used to increment or decrement the corresponding
	 * character of your message. Enjoy!
	 */
	public static void main(String[] args) {

		System.out.println("$ java VigenereCipher");
		System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher.");
		System.out.print("Would you like to encode or decode a message? ");
		Scanner obj = new Scanner(System.in);
		String input = obj.nextLine();

		if (input.equals("encode")) {
			System.out.print("Enter the string to encode: ");
			Scanner enc = new Scanner(System.in);
			String s = enc.nextLine();
			System.out.print("Enter the key: ");
			Scanner key = new Scanner(System.in);
			String s2 = key.nextLine();

			String keyString = VigenereCipher.replicate(s, s2);
			char[] arr = new char[s.length()];

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') // Make sure that only lowercase chars get encrypted
					arr[j] = VigenereCipher.encrypt(s.charAt(j), VigenereCipher.char2Int(keyString.charAt(j)));
			}
			String eString = new String(arr);
			System.out.println(eString);
		} else if (input.equals("decode")) {
			System.out.print("Enter the string to encode: ");
			Scanner enc = new Scanner(System.in);
			String s = enc.nextLine();
			System.out.print("Enter the key: ");
			Scanner key = new Scanner(System.in);
			String s2 = key.nextLine();

			String keyString = VigenereCipher.replicate(s, s2);
			char[] arr = new char[s.length()];

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') // Make sure that only lowercase chars get encrypted
					arr[j] = VigenereCipher.decrypt(s.charAt(j), VigenereCipher.char2Int(keyString.charAt(j)));
			}
			String eString = new String(arr);
			System.out.println(eString);
		} else
			System.err.println("Valid options are \"encode\" or \"decode\"");
	}
}
