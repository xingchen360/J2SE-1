package com.somnus.thread.lock;

public class SynObj {
	
	// 方法锁/或者对象锁
	public synchronized void methodA() {
		System.out.println("methodA.....");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void methodB() {
		// 对代码块进行锁，降低锁的竞争
		synchronized (this) {
			System.out.println("methodB.....");
		}
	}

	public void methodC() {
		String str = "sss";
		// 这里锁的是 str 这个对象，而不是 SynObj 对象
		synchronized (str) {
			System.out.println("methodC.....");
		}
	}
	
	public static void main(String[] args) {
        final SynObj obj = new SynObj();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodA();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodB();
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.methodC();
            }
        });
        t3.start();
    }
}