package com.app.thread.countdown;

import org.junit.Test;

public class ThreadRunnerTest
{

	@Test
	public void testRunThreads() throws Exception
	{
		ThreadRunner runner = new ThreadRunner();
		runner.runThreads();
		Thread.sleep(3000);
	}
}
