package com.app.ab.factory;


public class DimeConisFactory extends AbstractConisFactory {

	@Override
	public IConis createConisFactory() {

		return new DimeConis();
	}

}
