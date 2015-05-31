package com.app.ab.factory;


public class HalfDollarConisFactory extends AbstractConisFactory {

	@Override
	public IConis createConisFactory() {

		return new HalfDollar();
	}

}
