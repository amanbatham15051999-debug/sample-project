package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeEqualsAndHashcode;
import com.example.demo.entity.EmployeeOnlyEquals;
import com.example.demo.entity.EmployeeOnlyHashcode;

@SpringBootTest
public class TestHashSetOnEmployee {
	
	/*
	 * Test case to verify working of HashSet when
	 * the equals() and hashcode() methods are not implemented
	 * 
	 * Outcome: Since hashcode() and equals() both will show a mismatch
	 * hence the size of the HashSet came out to be 2
	 * */
	
	@Test
	public void testWithoutEqualsHashcode() {
		Employee emp1 = new Employee(1,"Aman","Batham");
		Employee emp2 = new Employee(1,"Aman","Batham");
		
		HashSet<Employee> employeeSet = new HashSet<>();
	    employeeSet.add(emp1);
	    employeeSet.add(emp2);
	    
	    assertEquals(2,employeeSet.size());
		
	}
	
	/*
	 * Test case to verify working of HashSet when
	 * only hashcode() methods is implemented.
	 * 
	 * Outcome: Since hashcode() will be calculating the index for the same bucket however
	 * equals() will be treating both the objects as not equals hence size of hashSet is 2.
	 * */
	@Test
	public void testWithOnlyHashcode() {
		EmployeeOnlyHashcode emp1 = new EmployeeOnlyHashcode(1,"Aman","Batham");
		EmployeeOnlyHashcode emp2 = new EmployeeOnlyHashcode(1,"Aman","Batham");
		
		HashSet<EmployeeOnlyHashcode> empSet = new HashSet<>();
		empSet.add(emp1);
		empSet.add(emp2);
		
		assertEquals(2,empSet.size());
	}
	
	/*
	 * Test case to verify working of HashSet when
	 * only equals() methods is implemented.
	 * 
	 * Outcome: Since hashcode() will be calculating the index for the different bucket this time
	 * hence size of hashSet is 2.
	 * */
	@Test
	public void testWithOnlyEquals() {
		EmployeeOnlyEquals emp1 = new EmployeeOnlyEquals(1,"Aman","Batham");
		EmployeeOnlyEquals emp2 = new EmployeeOnlyEquals(1,"Aman","Batham");
		
		HashSet<EmployeeOnlyEquals> empSet = new HashSet<>();
		empSet.add(emp1);
		empSet.add(emp2);
		
		assertEquals(2,empSet.size());
	}
	
	/*
	 * Test case to verify working of HashSet when
	 * both equals() and Hashcode() methods are implemented.
	 * 
	 * Outcome: Since hashcode() will be calculating the index for the same bucket this time
	 * and equals() will return true as the object params are equals this time.
	 * Hence the size of the set is 1.
	 * */
	@Test
	public void testWithBithEqualsAndHashcode() {
		EmployeeEqualsAndHashcode emp1 = new EmployeeEqualsAndHashcode(1,"Aman","Batham");
		EmployeeEqualsAndHashcode emp2 = new EmployeeEqualsAndHashcode(1,"Aman","Batham");
		
		HashSet<EmployeeEqualsAndHashcode> empSet = new HashSet<>();
		empSet.add(emp1);
		empSet.add(emp2);
		
		assertEquals(1,empSet.size());
	}
	
}
