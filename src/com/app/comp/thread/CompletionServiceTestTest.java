package com.app.comp.thread;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class CompletionServiceTestTest {

	@Test
	public void testThread() throws InterruptedException, ExecutionException {
		System.out.println("Normal Executor Service");
        long start = System.currentTimeMillis();
        new CompletionServiceDemo().normalExecutorService();
        System.out.println();
        System.out.println("Execution time : " + (System.currentTimeMillis() - start));

        System.out.println("Completion Service");
        start = System.currentTimeMillis();
        new CompletionServiceDemo().completionService();
        System.out.println();
        System.out.println("Execution time : " + (System.currentTimeMillis() - start));

        System.out.println("Normal Loop");
        start = System.currentTimeMillis();
        new CompletionServiceDemo().normalLoop();
        System.out.println();
        System.out.println("Execution time : " + (System.currentTimeMillis() - start));
	}

}
