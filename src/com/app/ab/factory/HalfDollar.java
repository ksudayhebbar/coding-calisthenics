package com.app.ab.factory;


public class HalfDollar extends AbstractCoins {
	public final int numberOfHalfDollarConis = 2;

	@Override
	public int getConis() {

		return dollar * numberOfHalfDollarConis;
	}

}
