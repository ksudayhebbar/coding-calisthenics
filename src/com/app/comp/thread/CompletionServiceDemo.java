package com.app.comp.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletionServiceDemo {
	private static final int waittime = 200;
	private static final int numberOfThreadsInThePool = 3;

	private final List<String> printRequests = Arrays.asList("1", "2", "3",
			"4", "5", "6", "7", "8", "9", "10", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "1", "2",
			"3", "4", "5", "6", "7", "8", "9", "10", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "1",
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "1", "2", "3", "4",
			"5", "6", "7", "8", "9", "10", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "1", "2", "3",
			"4", "5", "6", "7", "8", "9", "10");

	public void normalLoop() {
		for (String image : printRequests) {
			try {
				Thread.sleep(waittime);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.print(image);
		}
	}

	public void normalExecutorService() throws InterruptedException,
			ExecutionException {
		ExecutorService pool = Executors
				.newFixedThreadPool(numberOfThreadsInThePool);
		
		Set<Future<String>> printTaskFutures = new HashSet<Future<String>>();
		for (String image : printRequests) {

			Future<String> submit = pool.submit(new Printer(image));
			printTaskFutures.add(submit);
		}
		for (Future<String> future : printTaskFutures) {
			System.out.print(future.get());

		}
		if (pool != null) {
			pool.shutdownNow();
		}
	}

	public void completionService() throws InterruptedException,
			ExecutionException {
		Executor pool = Executors.newFixedThreadPool(numberOfThreadsInThePool);
		CompletionService<String> completionService = new ExecutorCompletionService<String>(
				pool);
		Set<Future<String>> printTaskFutures = new HashSet<Future<String>>();
		for (String immage : printRequests) {
			printTaskFutures.add(completionService.submit(new Printer(immage)));

		}

		for (int t = 0, n = printRequests.size(); t < n; t++) {
			Future<String> f = completionService.take();
			System.out.print(f.get());
		}
		if (pool != null) {
			((ExecutorService) pool).shutdownNow();
		}
	}

	public static void main(String[] args) throws IOException {
		


		String s = "abc";
		/*
		 * String s2 = s; System.out.println(s == s2);
		 */

		/* System.out.println(reverseRecursively("Uday")); */

		String s1 = new String(s);
		System.out.println(s1.intern());
		System.out.println(s == s1);
		System.out.println(s.intern());
/*
		FileReader fs = new FileReader("file");
		BufferedReader bf = new BufferedReader(fs);
		
		Writer out=new FileWriter("file");
		BufferedWriter bw=new BufferedWriter(out);*/
		
		
		

	}
}
