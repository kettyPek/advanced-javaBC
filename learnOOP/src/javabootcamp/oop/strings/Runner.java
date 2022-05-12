package javabootcamp.oop.strings;

import java.util.Scanner;

public class Runner {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		int selection;
		boolean inLoop = true;

		while (inLoop) {
			printMenu();
			selection = Integer.parseInt(scanner.nextLine());
			switch (selection) {
			case 1:
				question1();
				break;

			case 2:
				question2();
				break;

			case 3:
				question3();
				break;

			case 7:
				System.out.println("you exited");
				inLoop = false;
				break;
				
			default:
				System.out.println("incorrect selection, choose 1,2 or 3");
			}
		}
		scanner.close();
	}
	
	//display menu
	public static void printMenu() {
		String menuText = "Please enter the number of your selection from the following options:\r\n";
		menuText += "1. Enter 2 sentences and I’ll tell you if one is the other written backwards.\r\n";
		menuText += "2. Enter a word and I’ll tell you if it is a palindrome.\r\n";
		menuText += "3. Enter a sentence and a word and I’ll remove that word from anywhere in the sentence for you.\r\n";
		menuText += "7. Exit\r\n";
		System.out.println(menuText);
	}

	//Receive 2 sentences and return if one of them is the reveres of the other
	public static void sentencesWrittenBackwards(String sentence1, String sentence2) {
		String isBackwards = " ";
		int sent1Length = sentence1.length();

		if (sent1Length != sentence2.length())
			isBackwards = " NOT ";
		else {
			for (int i = 0; i < sent1Length; i++) {
				if (sentence1.charAt(i) != sentence2.charAt(sent1Length - i - 1)) {
					isBackwards = " NOT ";
					break;
				}
			}
		}
		System.out.println("The sentences are" + isBackwards + "the same");
	}

	//Receive a word, return true if the word is palindrome else returns false
	public static void wordIsPalindrome(String word) {
		String isPalindrome = " ";
		String copyWord = word;
		int wordLength = word.length();

		for (int i = 0; i < wordLength; i++)
			if (word.charAt(i) != copyWord.charAt(wordLength - 1 - i)) {
				isPalindrome = " NOT ";
				break;
			}
		System.out.println("The word is" + isPalindrome + "a palindrome");
	}

	//Remove a given word from the sentence
	public static void removeWord(String sentence, String word) {
		sentence = sentence.replaceAll(word, "");
		System.out.println(sentence);
	}
	
	//Scanning input by type
	public static String scanInput(String type) {
		System.out.println("Enter a " + type);
		String input = scanner.nextLine();
		return input;
	}
	
	//Handling question 1
	public static void question1() {
		String sentence1 = scanInput("sentence");
		String sentence2 = scanInput("sentence");
		sentencesWrittenBackwards(sentence1,sentence2);	
	}
	
	//Handling question 2
	public static void question2() {
		String word = scanInput("word");
		wordIsPalindrome(word);	
	}
	
	//Handling question 3
	public static void question3() {
		String sentence = scanInput("sentence");
		String word = scanInput("word");
		removeWord(sentence,word);	
	}


}