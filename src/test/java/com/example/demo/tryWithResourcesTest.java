package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.AutoCloseableResourceClass;

@SpringBootTest
public class tryWithResourcesTest {

	@Test
	public void testTryWithResources() throws Exception {
		try(AutoCloseableResourceClass res = new AutoCloseableResourceClass()){
			System.out.println("Was the resource Cloased "+res.isCLosed());
		}
		
		System.out.println("Did the resource closed after try catch block "+ AutoCloseableResourceClass.wasCLosed());
	}
}
