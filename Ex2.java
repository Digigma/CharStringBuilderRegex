/**
 * 
 */
package week6;

import java.util.ArrayList;
//import java.util.HashMap; // word count using HashMap
//import java.util.Map; // word count using HashMap
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author digig
 *
 */
public class Ex2 {

	/**
	 * @param args
	 */
	
	//One that tokenises a text and returns only the words that end with ly.
	//Sentence used in this ex is: 
	//He greedilly ate the skillfully and beautifully made cake.
	public static void printWordsWithLY(String s){
		String[] sTokens = s.split("\\p{javaWhitespace}");
	    for(int i = 0; i < sTokens.length; i++){
	        if(sTokens[i].endsWith("ly")){
	            System.out.print(sTokens[i] +" ");
	        }
	    }
	}
	
	//One that prints a table indicating the number of occurrences of each word in a given string/text.
	//Sentence used in this ex is: 
	//word word word three three nice hold hold hold
	public static void countWords(String s) {
		String[] separatedWords = s.split(" ");
		ArrayList<String> wordCounted = new ArrayList<>();
		
		for(String str : separatedWords) {
			if(!wordCounted.contains(str))
				wordCounted.add(str);
		}
		
		ArrayList<Integer> counts = new ArrayList<>();
		/*for(String str : wordCounted) {
			int count = 0;
			for(int i = 0; i<separatedWords.length; i++) {
				//if(separatedWords[i].equals(str))
					//count++;
			}
			counts.add(count);
		}*/
		
		//second way using regex
		for(String str : wordCounted) {
			Pattern P = Pattern.compile("\\b"+str+"\\b"); 
			Matcher m = P.matcher(s);
			int c = (int) m.results().count(); 
			counts.add(c);
		}
		//Table
		for(String str : wordCounted) 
			System.out.printf("%15s", str);
		System.out.println();
		for(int count : counts) 
			System.out.printf("%15d", count);
		System.out.println();
		
		/*
		 * A different way of counting the words in a string by using HashMap
		 * 
		String[] separatedWords = s.split(" ");
        Map <String, String> map = new HashMap <String, String> ();
 
        if (s != null) {
            for (String str: separatedWords) {
                if (map.containsKey(str)) {
                    int count = Integer.parseInt(map.get(str));
                    map.put(str, String.valueOf(count + 1));
                } else {
                    map.put(str, "1");
                }
            }
        }
        
        System.out.println("Count :- " + map);
		*/
	}
	
	//One that returns true if a given string is a correctly formatted TU Dublin email address.
	public static boolean validEmail(String email) {
	      String regex = "^[\\w.\\-]*@m?y?tudublin.ie";
	      return email.matches(regex);
	   }
            
	    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		//One that tokenises a text and returns only the words that end with ly.
		//Sentence used in this ex is: 
		//He greedilly ate the skillfully and beautifully made cake.
		System.out.println("Enter text for EX2a: ");
		String input = sc.nextLine();
		System.out.println("Words ending with 'ly': ");
		printWordsWithLY(input);
		System.out.println("\n");
		
		
		
		//One that prints a table indicating the number of occurrences of each word in a given string/text.
		//Sentence used in this ex is: 
		//word word word three three nice  hold hold hold
		System.out.println("Enter text for EX2b: ");
		input = sc.nextLine();
		countWords(input);
		System.out.println("\n");
		

		//One that returns true if a given string is a correctly formatted TUDublinemail address.
		System.out.println("Enter text for EX2c: ");
		while(true) {
			System.out.println("Press 'X' to exit the program or ");
			System.out.println("Enter email address: ");
			input = sc.nextLine();
			if(input.toUpperCase().equals("X")) {
				break;
			}
			
			if (validEmail(input)){
				  System.out.println("Email "+input+" Is valid TU Dublin email");
				}else{
				System.out.println("Email "+input+" Is NOT valid TU Dublin email");
				}
		}
		
		sc.close();
		
	}

}
