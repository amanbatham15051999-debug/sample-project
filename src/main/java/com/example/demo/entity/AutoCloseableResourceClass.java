package com.example.demo.entity;

public class AutoCloseableResourceClass implements AutoCloseable{

	private static boolean closed = false;
	
	
	
	public AutoCloseableResourceClass() {
		System.out.println("Resource Created");
	}

	public boolean isCLosed() {
		return closed;
	}
	
	public static boolean wasCLosed() {
		return closed;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		closed = true;
		System.out.println("Resource Closed Automatically");
	}

}
