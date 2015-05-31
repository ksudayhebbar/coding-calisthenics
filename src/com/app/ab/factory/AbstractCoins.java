package com.app.ab.factory;


public abstract class AbstractCoins implements IConis {
	protected int dollar;

	public AbstractCoins() {
		this.dollar = 0;
	}

	@Override
	public void putMoney(int dollar) {
		if (dollar >= 1) {
			this.dollar = dollar;
		}

	}
}
