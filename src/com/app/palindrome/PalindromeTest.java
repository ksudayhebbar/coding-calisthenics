package com.app.palindrome;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {
	private Palindrome palindrome;

	@Before
	public void setUp() {
		palindrome = new Palindrome();

	}

	@Test
	public void isPalindromeTest() {

		Assert.assertEquals("Is a palindrome String ", true,
				palindrome.isPalindrome("pop"));
		Assert.assertEquals("Is a palindrome String ", true,
				palindrome.isPalindrome("Ah,Satan sees Natasha"));
		Assert.assertEquals("Is a palindrome String ", false,
				palindrome.isPalindrome("pops"));
		Assert.assertEquals("Is a palindrome String ", false,
				palindrome.isPalindrome("Ah,Satan sees Natashas"));

	}
}