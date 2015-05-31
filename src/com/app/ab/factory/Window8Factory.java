package com.app.ab.factory;


import com.app.ab.factory.AbstractWindowFactory;

public class Window8Factory extends AbstractWindowFactory {

	@Override
	public IWindow getWindows() {

		return new Windows8();
	}

}
