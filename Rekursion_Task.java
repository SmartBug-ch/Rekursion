package Rekursion;

import java.util.*;

// GENERAL READ ME:

// Start off solving the easy exercise if you feel still unfamiliar with recursion.
// If you think you already understood the concept quite well, go straight to the intermediate section.
// The hard exercises are bonus tasks / exam tasks from previous years of EPROG or similarly hard problems.

// You are encouraged to write helper methods if you need additional attributes other than
// the ones given in the method signatures.

// ***!!Remember to not change method signatures in a bonus task or 
// exam situation!!***

//************************

// You can use the container below to add
// Strings you find in a method and print the container after the method call
// to have a look at what you have found.
// if you want to make multiple method calls, make sure to use 
// container.clear() inbetween.

// There is a demonstration in the main method of the Rekursion_sol class.

// ************************

// Finally, a distinction between SUBSEQUENCES and SUBSTRINGS:

// a SUBSEQUENCE is a subset of characters of a string in ascending order, but not necessarily consecutive.

// a SUBSTRING is a consecutive subset of characters of a string.

// the String "llo" is a substring and a subsequence of "Hallo". The string "hlo" is a subsequence of "Hallo"
// but not a substring.

public class Rekursion_Task {
	
	
	static LinkedList<String> container = new LinkedList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factorial(4);
		int i = factorial(7);
		System.out.println(i);
		
		i = power(5,5);
		System.out.println(i);
		
		countdown(5);
		i = occurenceOfX(131215331, 1, 0);
		System.out.println(i);
		
		i = bunnyEars(6, 0);
		System.out.println(i);	
	}
	// ------------- Start Easy Recursion Exercises -------------
	public static int factorial (int n) {
		
		// write a method that calculates n! recursively	

		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);

		


	}	
	public static int power(int base, int exponent) {
		
		// calculate base^exponent recursively
		if(exponent <= 0) {
			return 1;
		}
		return base * power(base,  exponent - 1);
	}	
	public static void countdown(int n) {
		
		// write a recursive method that counts down from n to 1
		// i.e. a call countdown(3) should print something like below to the console:
		
		// 3
		// 2
		// 1
		// Go!
		
		if(n <= 0) {
			System.out.println("go!! go gooooo!!!!");
		}
		else {
		System.out.println(n);
		countdown(n-1);
		}
	}
	public static int occurenceOfX(int n, int x, int occurences) {
		
		// count the number of occurences of the digit x in the integer n
		// hint: use the % operator and integer division
		
		// in the int 143241, the digit 4 occurs 2 times, as does the digit 1, whereas the digits 2 and 3 occur 1 time each.
		
		
		
		if(n % 10 == x) {
			occurences++;
			return occurenceOfX(n/10, x, occurences);
		}
		else if(n <= 10) {
			return occurences;
		}
		else{
			return occurenceOfX(n/10, x, occurences);
		}
		
	}
	public static int bunnyEars(int n, int numOfEars) {
		
		// there are n bunnies standing in a line, numbered 1,2, ... , n
		// Even bunnies have two ears
		// odd bunnies have three ears (two plus a raised foot. :D )
		// count the number of ears for n bunnies using recursion
		
		if(n <= 0) {
			return numOfEars;
		}
		else if(n % 2 == 0) {
			numOfEars += 2;
			return bunnyEars(n - 1, numOfEars);
		}
		else {
			numOfEars += 3;
			return bunnyEars(n - 1, numOfEars);
		}		
	}
	// ------------- End Easy Recursion Exercises -------------
	// ------------- Start Intermediate Recursion Exercises -------------
	public static void teilfolgen(String input) {
		
		// find all subsequences (teilfolgen) of the input string
		// add them to the container using
		// container.add(teilfolge);
		// such that they can be looked at after the call to teilfolgen()
	
	}
	
	public static boolean splitArray(int[] arr) {
		
		// return a boolean that indicates whether the array arr[]
		// can be split into two partitions such that they have equal sum.
		// Use all elements of arr.
		
		return false;
		
	}
	
	public static boolean groupSum(int [] arr, int target_sum) {
		
		// return a boolean indicating whether some elements of the array arr[] can be summed
		// up to a target sum.
		
		return false;
		
	}
	
	// ------------- End Intermediate Recursion Exercises -------------
	
	
	
	
	// ------------- Start Hard Recursion Exercises -------------
	
	public static void permutations(String input) {
		
		// permute the string, i.e. find all the arrangements of the characters in the string
		// E.g. the string "123" has six permutations, namely:
		// "123", "132", "213", "231", "312", "321"
		
		// Hint: a method that swaps two characters in a string might be useful
		
	}

	
	public static void interleaving(String s, String t) {
		 
		// aka Verzahnung, Bonustask from 2018
		// given two strings s and t, find all their interleavings. 
		// E.g. the string "12" and "ab" have the following interleavings:
		// "12ab", "1a2b", "1ab2", "a12b", "a1b2", "ab12" 

	 }
	
	public static void teilfolgenLaenge(String input, String teilfolge, int len) {
		
		// find all subsequences of the input string that have length len
		
		
	}
	
	public static boolean mindestAnzahlTeilfolgen (String s, String t, int n) {
		
		return false;
	}
	
	
	public static boolean enthaltenMitAbstand(String input, String teil, int k) {
		
		// Bonus Task from a previous year
		
		// check whether the string teil occurs as
		// a subsequence of string input where the characters in the subsequence have at most
		// a distance (Abstand) of k, but can occur in any order.
		
		// Example to make clear what is meant by distance: in the string "a12345b" the characters
		// 'a' and 'b' have a distance of 5.
		
		// Examples of how the method should behave:
		
		// s = "abbbc", t = "cab", k = 1. The method should return true. The valid subsequence is the first, the second
		// and the third character in s.
		
		// s = "abbbbc", t = "cab", k = 1. The method should return false. 
		
		// s = "abc", t = "ccab", k = 1. The method should return false, since there is no subsequence of s with two 'c's.
		
		
		return false;
		
	}
	
	
	public static Set<List<Integer>> palindrome (List<Integer> input) {
		
		// Bonus Task from a previous year
		
		// find all sublists of the list input that are palindromes.
		// A palindrome is a word that reads the same way forwards and backwards.

		// E.g. for the list [13,13,4,13,4,2] the method should return the following list of lists:
		// [[13, 13], [2], [4], [13, 4, 13], [4, 13, 4], [13]]
		// where the order of lists does not matter. 
		
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		
		return result;
	}

	
	// ------------- End Hard Recursion Exercises -------------
	


}
