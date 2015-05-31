package com.app.ab.factory;


public class ConisVendingClient {
	public int getConis(AbstractConisFactory abstractConisFactory, int dollar) {
		IConis c = abstractConisFactory.createConisFactory();
		c.putMoney(dollar);
		return c.getConis();

	}

}
