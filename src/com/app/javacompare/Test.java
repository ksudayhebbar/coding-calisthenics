package com.app.javacompare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Test {
	private static String DATE_STRING_FORMAT = "MM/dd/yyyy";

	private static final String OFFER_START_DATE = "07/12/2014";

	static List<Account> accountList = new ArrayList<Account>();

	/**
	 * Takes a properly formatted string and converts to a java.util.date.
	 * 
	 * @param date
	 *            the date to parse
	 * @return a date as java.util.Date
	 * @throws ParseException
	 */
	private static Date getDateFromString(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_STRING_FORMAT,
				Locale.ENGLISH);

		return sdf.parse(date);
	}

	public Test() throws ParseException {
		accountList
				.add(new Account("a", new Date(1, 12, 2012), 750.00, 1000.00));
		accountList.add(new Account("b", new Date(1, 12, 2011), 10000.00,
				10000.00));
		accountList.add(new Account("c", new Date(9, 12, 2011), 1999.00,
				4200.00));
	}

	public static void getAccountData() {
		getAccountsInOrder(accountList);
	}

	/**
	 * Primary implementation method. Takes a list of accounts and returns the
	 * top 3 as a String array of names.
	 *
	 * @param accounts
	 *            the list of accounts to evaluate.
	 * @return a String array of length X of the names of the top qualifying
	 *         accounts.
	 */
	protected static String[] getAccountsInOrder(List<Account> accounts) {
		// YOUR CODE GOES HERE
		// CHANGE null TO YOUR VARIABLE!
		Collections.sort((List) accounts, new Comparator<Account>() {

			@Override
			public int compare(Account o1, Account o2) {

				return o1.getAccountScore() > o2.getAccountScore() ? -1 : 1;
			}
		});

		String[] accountsArray = new String[accounts.size()];
		//accounts.toArray(accountsArray);
		int i = 0;
		for (Account a : accounts) {
			accountsArray[i] = a.toString();
			System.out.println(a.toString());
			i++;

		}
		
		return accountsArray;
	}

	/**
	 * Account object...the primary object for this class.
	 */
	public class Account {
		private String name;

		private Date accountOpenDate;

		private Double accountCurrentBalance;

		private Double accountCreditLimit;

		private int ageInMonthsAtTimeOfOffer;

		private Double accountScore;

		public Account() {
			// TODO Auto-generated constructor stub
		}

		public Account(String name, Date accountOpenDate,
				Double accountCurrentBalance, Double accountCreditLimit)
				throws ParseException {
			this.name = name;
			this.accountOpenDate = accountOpenDate;
			this.accountCurrentBalance = accountCurrentBalance;
			this.accountCreditLimit = accountCreditLimit;
			setAge();
			setScore();
		}

		public String getName() {
			return name;
		}

		public Date getAccountOpenDate() {
			return accountOpenDate;
		}

		public Double getAccountCurrentBalance() {
			return accountCurrentBalance;
		}

		public Double getAccountCreditLimit() {
			return accountCreditLimit;
		}

		public int getAgeInMonthsAtTimeOfOffer() {
			return ageInMonthsAtTimeOfOffer;
		}

		public Double getAccountScore() {
			return accountScore;
		}

		public void setAge() throws ParseException {
			Date date = new Date();
			int m1 = this.accountOpenDate.getYear() * 12 + date.getMonth();
			int m2 = date.getYear() * 12 + date.getMonth();
			this.ageInMonthsAtTimeOfOffer = m2 - m1 + 1;

		}

		public void setScore() {
			this.accountScore = this.accountCreditLimit
					- this.accountCurrentBalance / 100;

		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.name;
		}

	}

	public static void main(String[] args) throws ParseException {
		new Test().getAccountData();
	}
}
