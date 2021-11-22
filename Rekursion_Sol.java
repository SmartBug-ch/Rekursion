package Rekursion;

import java.util.*;

public class Rekursion_Sol {
	
	// You can use the container below to add 
	// Strings you find in a method and print the container after the method call
	// to have a look at what you have found.
	// if you want to make multiple method calls, make sure to use 
	// container.clear() inbetween.
	
	static LinkedList<String> container = new LinkedList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Demonstration of how to use the container
		teilfolgenLaenge("Apple", "", 3);
		System.out.println(container);
		container.clear();
		
		permutations("Flo", 0);
		System.out.println(container);
		container.clear();
		
		
		// Testing some other method
		System.out.println(mindestAnzahlTeilfolgen("Hallo", "alo", 2));
		System.out.println(mindestAnzahlTeilfolgen("Hallo", "alo", 3));
		
		
		// creating a list for input to palindrome()
		LinkedList<Integer> input = new LinkedList<Integer>();
		
		input.add(13);
		input.add(13);
		input.add(4);
		input.add(13);
		input.add(4);
		input.add(2);
		
		System.out.println(input);
		System.out.println(palindrome(input));
		
		
	}
	
	// ------------- Start Easy Recursion Exercises -------------
	
	public static int factorial (int n) {
		
		if (n <= 1) {
			return 1;
		}
		return n* factorial(n-1);
		
	}	
	
	public static int power(int base, int exponent) {
		
		// calculate base^exponent recursively
		
		if (exponent == 0) return 1;
		
		return base * power(base, exponent -1);
	}	
	
	public static void countdown(int n) {
		System.out.println(n);
		if (n > 0) {
			countdown(n-1);
		}
		
	}
	
	public static int occurenceOfX(int n, int x, int occurences) {
		
		// count the number of occurences of the digit x in the integer n
		// hint: use the % operator and integer division
		
		if (n == 0) return occurences;
		
		if (n%10 == x) occurences++;
		
		return occurenceOfX(n / 10, x, occurences);
	}
	
	public static int bunnyEars(int n, int numOfEars) {
		
		// there are n bunnies standing in a line, numbered 1,2, ... , n
		// Even bunnies have two ears
		// odd bunnies have three ears (two plus a raised foot. :D )
		// count the number of ears for n bunnies using recursion
		
		if (n == 0) return numOfEars;
		
		if (n %2 == 0) {
			numOfEars+=2;
		} else {
			numOfEars+=3;
		}
		
		return bunnyEars(n-1, numOfEars);
		
	}
	
	// ------------- End Easy Recursion Exercises -------------
	
	
	
	// ------------- Start Intermediate Recursion Exercises -------------
	
	public static void teilfolgen(String input, String teilfolge, int index) {
		
		// find all subsequences (teilfolgen) of the input string
		// add them to the container using
		// container.add(teilfolge);
		// such that they can be looked at after the call to teilfolgen()
	
		if (index >= input.length()) {
			container.add(teilfolge);
		} else {
			teilfolgen(input, teilfolge + input.charAt(index), index + 1);
			teilfolgen(input, teilfolge, index + 1);
		}
	}
	
	public static boolean splitArray(int[] arr, int index, int bal) {
		
		// return a boolean that indicates whether the array arr[]
		// can be split into two partitions such that they have equal sum
		// use all elements of arr
		
		if (index >= arr.length) return bal == 0;
		
		return splitArray(arr, index+1, bal+arr[index])
				|| splitArray(arr, index+1, bal-arr[index]);
		
	}
	
	public static boolean groupSum(int [] arr, int index, int current_sum, int target_sum) {
		
		// return a boolean indicating whether elements of the array arr[] can be summed
		// up to a target sum
		
		if (current_sum == target_sum || index >= arr.length) return current_sum == target_sum;
		
		return groupSum(arr, index+1, current_sum + arr[index], target_sum)
				|| groupSum(arr, index+1, current_sum, target_sum);
		
	}
	
	// ------------- End Intermediate Recursion Exercises -------------
	
	
	
	
	// ------------- Start Hard Recursion Exercises -------------
	
	public static void permutations(String input, int index) {
		
		// permute the string, i.e. find all the arrangements of the characters in the string
		// E.g. the string "123" has six permutations, namely:
		// "123", "132", "213", "231", "312", "321"
		
		// Hint: a method that swaps two characters in a string might be useful
		
		if (index >= input.length()) {
			container.add(input);
		} else {
			
			for (int i = index; i < input.length(); i++) {
                
                permutations(swap(input, index, i), index+1);
                
            }
			
		}
		
	}
	
	public static String swap(String input, int pos1, int pos2) {
		
		if (pos1 == pos2) return input;
		
		String result = input.substring(0, pos1);
		result += input.charAt(pos2);
		result += input.substring(pos1+1, pos2);
		result += input.charAt(pos1);
		result += input.substring(pos2+1, input.length());
		
		return result;
	}
	
	public static void interleaving(String combination, String s, String t) {
		 
		// aka Verzahnung, Bonustask from 2018
		// given two strings s and t, find all their interleavings. 
		// E.g. the string "12" and "ab" have the following interleavings:
		// "12ab", "1a2b", "1ab2", "a12b", "a1b2", "ab12" 
		
		 if (s.isEmpty()) {
			 combination = combination + t;
			 container.add(combination);
			 return;
			 
		 } else if (t.isEmpty()) {
			 combination = combination + s;
			 container.add(combination);
			 return;
			 
		 } else {
			 
			 interleaving(combination + s.substring(0, 1), s.substring(1), t);
			 interleaving(combination + t.substring(0, 1), s, t.substring(1));
		 }
	 }
	
	public static void teilfolgenLaenge(String input, String teilfolge, int len) {
		
		// find all subsequences of the input string that have length len
		
		if (len == 0) {
			container.add(teilfolge);
		} else {
			
			if (input.length()>= 1) {
				
				teilfolgenLaenge(input.substring(1), teilfolge, len);
				teilfolge += input.charAt(0);
				teilfolgenLaenge(input.substring(1), teilfolge, len-1);
				
			}
			
		}
		
		
	}
	
	public static boolean mindestAnzahlTeilfolgen (String s, String t, int n) {
		
		// check whether the string t occurs at least n times as a subsequence
		// of string s
		
		return helpRec(s,t,"", 0) >= n;
	}
	
	public static int helpRec (String s, String t, String teilfolge, int index) {
		
		// modified Substring() method, instead of just printing all substrings
		// we count the ones that match the teilfolge
		
		if (index >= s.length()) {
			return teilfolge.equals(t) ? 1 : 0;
		} else {
			return helpRec(s,t, teilfolge + s.charAt(index), index + 1)
					+ helpRec(s,t, teilfolge, index + 1);
		}
	}
	
	public static boolean enthaltenMitAbstand(String input, String teil, int k) {
		
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
		
		
		
		boolean b = false;
		
		for (int i = 0; i < input.length(); i++) {
			
			// we iterate over the whole length of the input String.
			// once we found matching characters, we call the helper method
			// where we will only iterate over k+1 (Abstand) chars of the input string
			// 
			// One can think of this as fixing the first matching character and from there
			// the Abstand rule comes into play for all further matching characters to be found
			
			for (int j = 0; j < teil.length(); j++) {
				if (input.charAt(i) == teil.charAt(j)) {
					b = b || helpAbstand(input.substring(i), teil.substring(0, j) + teil.substring(j+1), k, false);
				}
			}
		}
		
		return b;
		
	}
	
	public static boolean helpAbstand(String input, String teil, int k, boolean b) {
		
		if (teil.isEmpty()) {
			return true;
		}
		
		// Once this method is called, the first matching character has been fixed
		// we only iterate over the k+1 next following characters in the input string
		// to find another matching character
		
		for (int i = 0; i <= k+1 && i < input.length(); i++) {
			for (int j = 0; j < teil.length(); j++) {
			
				if (input.charAt(i) == teil.charAt(j)) {
					
					b = b || helpAbstand(input.substring(i), teil.substring(0, j) + teil.substring(j+1), k, b);						
					
				}
				
			}			
		}
		return b;
	}
	
	public static Set<List<Integer>> palindrome (List<Integer> input) {
		
		// find all sublists of the list input that are palindromes.
		// A palindrome is a word that reads the same way forwards and backwards.

		// E.g. for the list [13,13,4,13,4,2] the method should return the following list of lists:
		// [[13, 13], [2], [4], [13, 4, 13], [4, 13, 4], [13]]
		// where the order of lists does not matter. 
		
		Set<List<Integer>> result = new HashSet<List<Integer>>();
		
		// try to find palindromes for all pairs of successive start and end indices	
		for (int start = 0; start < input.size(); start++) {
			for (int end = input.size()-1; end >= start; end--) {
				
				LinkedList<Integer> current = new LinkedList<Integer>();
				
				if (helpPalindrome(input, current, start, end, result)) {
					result.add(current);
				}
				
			}
		}
		
		return result;
	}
	
	public static boolean helpPalindrome(List<Integer> input, LinkedList<Integer> palindrome, int start, int end, Set<List<Integer>> result) {
		
		if (start == end) {
			// found palindrome of uneven size
			
			palindrome.add(input.get(start));
			return true;
			
		} else if (start == end -1 && input.get(start) == input.get(end)) {
			// found palindrome of even size
			
			palindrome.add(input.get(start));
			palindrome.add(input.get(end));
			return true;
			
		} else if (input.get(start) == input.get(end)) {
			
			if (helpPalindrome(input, palindrome, start+1, end-1, result)) {
				// recursive call has found a palindrome, so we add the current ints
				palindrome.add(0, input.get(start));
				palindrome.add(input.get(end));
				return true;
			}			
		}
		return false;		
	}
	
	// ------------- End Hard Recursion Exercises -------------
	


}
