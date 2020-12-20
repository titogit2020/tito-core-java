package org.khalidmughal.thread;

public class MyClassSync extends Thread 
{
	static Object lock1 = new Object();
	static Object lock2 = new Object();
	
	static volatile int i1,i2,j1,j2,k1,k2;
	
	public void run()
	{
		int cnt=0;
		//while(true)
		while(cnt <= 5000)
		{
			doit();
			check();
			cnt++;
		}
	}
	
	void doit()
	{
		synchronized(lock1){i1++;}
		j1++;
		synchronized(lock2){k1++;k2++;}
		j2++;
		synchronized(lock1){i2++;}
	}
	void check()
	{
		if(i1 != i2) System.out.println("i");
		if(j1 != j2) System.out.println("j");
		if(k1 != k2) System.out.println("k");
	}
	public static void main(String[] args) 
	{
		new MyClassSync().start();
		new MyClassSync().start();
	}
}  // End of class MyClassSync
