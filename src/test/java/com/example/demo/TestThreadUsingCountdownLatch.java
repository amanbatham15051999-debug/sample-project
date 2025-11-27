package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestThreadUsingCountdownLatch {

	@Test
	public void testExecutorService() throws InterruptedException, ExecutionException {
		ExecutorService  executor = Executors.newFixedThreadPool(5);
		
		CompletableFuture<?>[] firstFourTasks = IntStream.range(1, 5).mapToObj(i-> CompletableFuture.runAsync(()->{
			System.out.println("Thread "+i+" started processing");
			try {
				Thread.sleep(1000,2000);
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
		},executor)).toArray(CompletableFuture[]::new);
		
		CompletableFuture<Void> fifthTask = CompletableFuture.allOf(firstFourTasks).thenRunAsync(()->{
			System.out.println("Task 5 running after all threads completed execution");
			try {
			Thread.sleep(1000);
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			System.out.println("Task 5 completed successfully");
		},executor);
		
		fifthTask.get();
		executor.shutdown();
	}
}
