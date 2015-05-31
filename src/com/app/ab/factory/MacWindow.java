package com.app.ab.factory;


public class MacWindow implements IWindow {

	@Override
	public void createWindow() {
		System.out.println("Mac created window ");

	}

	@Override
	public void rePaint() {
		System.out.println(" Mac repaint");

	}

}
