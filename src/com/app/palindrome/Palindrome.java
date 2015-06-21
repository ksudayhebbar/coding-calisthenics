package com.app.palindrome;

public class Palindrome {

	private boolean checkForPalindrome(String word) {
		if (word == null) {
			return false;
		} else {
			boolean validPalindrome = true;
			//comapre last to first word 
			for (int i = 0; i < word.length() / 2; i++) {
				// try to disprove isPalindrome
				if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
					// it isn't a palindrome, so flag it as such and stop
					// checking
					validPalindrome = false;
					break;
				}

			}
			return validPalindrome;
		}
	}

	private String truncateSpecialCharacter(String sentence) {
		// remove all the Alphanumeric Tokens
		String replacedSentence = sentence.replaceAll("[^\\w]", "");
		return replacedSentence;

	}

	public boolean isPalindrome(String pharase) {
		if (pharase != null) {
			String replacedSentence = truncateSpecialCharacter(pharase
					.toLowerCase());
			return checkForPalindrome(replacedSentence.trim()) != false ? true
					: false;
		}
		return false;
	}
}
