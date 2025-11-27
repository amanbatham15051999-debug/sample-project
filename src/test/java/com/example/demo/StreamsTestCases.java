package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StreamsTestCases {

	@Test
	public void testSquareOfEachNumsUsingStreams() {
		ArrayList<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);
		integerList.add(6);
		integerList.add(7);
		integerList.add(8);
		integerList.add(9);
		integerList.add(10);
		
		List<Integer> listOfSquares =  integerList.stream().map(i-> i*i).collect(Collectors.toList());
		
		System.out.println(listOfSquares);
	}
	
	@Test
	public void testSquareOfEvenNumsUsingStreams() {
		ArrayList<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);
		integerList.add(6);
		integerList.add(7);
		integerList.add(8);
		integerList.add(9);
		integerList.add(10);
		
		List<Integer> listOfSquares =  integerList.stream().filter(i-> i%2==0).map(i-> i*i).collect(Collectors.toList());
		
		System.out.println(listOfSquares);
	}
}
