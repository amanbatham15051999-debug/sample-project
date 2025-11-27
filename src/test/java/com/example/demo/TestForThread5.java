package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.MyThread;

/*
 * Test to make sure the execution of thread 5 starts only after Thread 1,2,3,4
 * finished execution
 * */

@SpringBootTest
public class TestForThread5 {

	@Test
	public void testThread5Run() throws InterruptedException{
		MyThread myTask = new MyThread();
		Thread t1 = new Thread(myTask,"worker-1");
		Thread t2 = new Thread(myTask,"worker-2");
		Thread t3 = new Thread(myTask,"worker-3");
		Thread t4 = new Thread(myTask,"worker-4");
		Thread t5 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+ " started");
			
			try {
				t1.join();
				t2.join();
				t3.join();
				t4.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
			}
			
			try {
				System.out.println(Thread.currentThread().getName()+" executing");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ " ended");
			
		},"worker-5");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		t5.join();
	}
}
