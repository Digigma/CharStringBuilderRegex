/**
 * 
 */
package week6;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author digig
 *
 */
public class Ex1 {

	/**
	 * @param args
	 */
	//One that returns the reversed version of a given string.
	public static String reverseStringUsingSB(String s) {
		StringBuilder rev = new StringBuilder("");
		
		int begin = s.length()-1;
		
		for(int i = begin; i>=0; i--) {
			rev.append(s.charAt(i));
		}
		return rev.toString();
		
	}
	
	//One that prints a table indicating the number of occurrences of each character in a given string.
	public static void printCharTable (String str, boolean lower) {
		if(lower)
			str = str.toLowerCase();		
		
		char[] chars = str.toCharArray();
		ArrayList<Character> uniqueChars = new ArrayList<>();
		
		for(char c : chars) {
			if(!uniqueChars.contains(c))
				uniqueChars.add(c);
		}
		//System.out.println(uniqueChars);
		
		ArrayList<Integer> counts = new ArrayList<>();
		for(char c : uniqueChars) {
			int count = 0;
			for(int i = 0; i<chars.length; i++) {
				if(chars[i] == c)
					count++;
			}
			counts.add(count);
		}
		//System.out.println(counts);
		for(char c : uniqueChars) 
			System.out.printf("%3c", c);
		System.out.println();
		for(int count : counts) 
			System.out.printf("%3d", count);
		System.out.println();
	}
	
	//One that returns the total numeric value of a given string.
	public static int totalStringValue (String s) {
		int cummulativeCharsVal = 0;
		
		char[] chars = s.toCharArray();
		
		for(char c : chars) {
			cummulativeCharsVal += (int) c;
		}
		
		return cummulativeCharsVal;
		
	}
	
	//One that returns the version of a string where every vowel is replaced with its numerical value.
	public static String replaceVowels(String s) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		for(char vowel : vowels) {
			s = s.replace(vowel + "", ((int)vowel) + "");
		}
		
		return s;
	}
	
	//One that process a list of strings and prints only the middle portion of each of these strings.
	public static void printMiddles(ArrayList<String> words) {
		System.out.println("Printing the middle of each word: ");
		
		for(String word : words) {
			//if(word.length()>=2)
				System.out.println(word.substring(1, word.length()-1));
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter some text: ");
		String input = sc.nextLine();
		
		//One that returns the reversed version of a given string.
		System.out.println("Reverse string is: " + reverseStringUsingSB(input));
		System.out.println();
		
		//One that prints a table indicating the number of occurrences of each character in a given string.
		printCharTable(input, true);
		System.out.println();
		
		//One that returns the total numeric value of a given string.
		System.out.println("The total string value is " +totalStringValue(input));
		System.out.println();
		
		//One that returns the version of a string where every vowel is replaced with its numerical value.
		System.out.println("Replaced vowels are: " +replaceVowels(input));
		System.out.println();
		
		//One that process a list of strings and prints only the middle portion of each of these strings.
		String[] words = input.split("\\p{javaWhitespace}+");
		ArrayList<String> tokens = new ArrayList<>();
		for(String w: words)
			tokens.add(w);
		printMiddles(tokens);
		
		sc.close();

	}

}
