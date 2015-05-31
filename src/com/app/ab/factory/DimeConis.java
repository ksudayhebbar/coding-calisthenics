package com.app.ab.factory;


public class DimeConis extends AbstractCoins {
	public final int numberOfDimConis = 4;

	@Override
	public int getConis() {

		return dollar * numberOfDimConis;
	}

}
