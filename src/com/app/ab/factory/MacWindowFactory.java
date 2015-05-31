package com.app.ab.factory;


public class MacWindowFactory extends AbstractWindowFactory {

	@Override
	public IWindow getWindows() {

		return new MacWindow();
	}

}
