package controller;

public class ThreadId extends Thread {

	public ThreadId() {
		super();
	}

	@Override
	public void run() {
//		int tid = getId();
		int tid = (int) threadId();
		System.out.println("#"+tid);
	} 

}

/*
 *extends Thread
 *run()
 *Passagem de parâmetros apenas por contrutor de classe
 */