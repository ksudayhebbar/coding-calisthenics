package com.app.ab.factory;


public class GUIBuilder {
	public void buildWindow(AbstractWindowFactory widgetFactory) {
		IWindow window = widgetFactory.getWindows();
		window.createWindow();
		window.rePaint();
	}
}
