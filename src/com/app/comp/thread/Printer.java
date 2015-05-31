package com.app.comp.thread;

import java.util.concurrent.Callable;

public class Printer implements Callable<String> {

	 private final String toPrint;
	 private static final int waittime = 200;
     public Printer(String toPrint) {
             this.toPrint = toPrint;
     }

     public String call() {
             try {
                     Thread.sleep(waittime);
             } catch (InterruptedException e) {
                     e.printStackTrace();
             }
             return toPrint;
     }
}
