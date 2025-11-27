package com.example.demo;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Employee;

@SpringBootTest
public class TestTreeSetSortingOrder {
	
	/*
	 * Test to understand the natural sorting order maintained in a TreeSet
	 * TreeSet is an implementation of Self Balancing BST - {Red-Black Tree}
	 * */
	
	@Test
	public void testNaturalSortingOrder() {
		TreeSet<Employee> empSet = new TreeSet<>();
		empSet.add(new Employee(3,"Harsh","Batham"));
		empSet.add(new Employee(1,"Aman","Batham"));
		empSet.add(new Employee(2,"Priyanshi","Batham"));
		
		System.out.println(empSet);
	}
	
	@Test
	public void testCustomSortingOrder() {
		Comparator<Employee> empCustomComparator = Comparator.comparing(Employee::getFirstname).thenComparing(Employee::getLastname);
		
		TreeSet<Employee> empSet = new TreeSet<>(empCustomComparator);
		empSet.add(new Employee(1,"Harsh","Batham"));
		empSet.add(new Employee(2,"Aman","Batham"));
		empSet.add(new Employee(3,"Aman","Patel"));
		empSet.add(new Employee(4,"Priyanshi","Batham"));
		empSet.add(new Employee(5,"Priyanshi","Pathak"));
		
		System.out.println(empSet);
		
	}

}
