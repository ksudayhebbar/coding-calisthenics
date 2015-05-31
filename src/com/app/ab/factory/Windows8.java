package com.app.ab.factory;


public class Windows8 implements IWindow {

	@Override
	public void createWindow() {
		System.out.println("Windows -8 window craeted");

	}

	@Override
	public void rePaint() {
		System.out.println("window -8 repainted");
	}

}
