package com.app.ab.factory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GUIBuilderTest {
	private GUIBuilder builder;
	private AbstractWindowFactory widgetFactory = null;

	@Before
	public void setUp() throws Exception {
		builder = new GUIBuilder();
	}

	@After
	public void tearDown() throws Exception {
		builder = null;

	}

	@Test
	public void buildWindow() {
		widgetFactory = new MacWindowFactory();
		builder.buildWindow(widgetFactory);
		widgetFactory = new Window8Factory();
		builder.buildWindow(widgetFactory);

	}

}
