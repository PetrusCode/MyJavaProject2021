package com.netmind.business.integration.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.netmind.business.Calculator;

public class CalculatorIntegrationTest {
	//Tests de integracion
	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		assertEquals(calculator.add(4,2), 6);
		
	}

	@Test
	public void testSubstract() {
		Calculator calculator2 = new Calculator();
		assertEquals(calculator2.substract(5, 5), 0);
	}

	@Test
	public void testMultiply() {
		Calculator calculator3 = new Calculator();
		assertEquals(calculator3.multiply(5, 5), 25);
	}

	@Test
	public void testDivide() {
		Calculator calculator4 = new Calculator();
		assertEquals(calculator4.divide(100, 100),1);
	}
	
	@Test
	public void testSumPares() {
		Calculator calculator5 = new Calculator();
		assertEquals(calculator5.arraySum(),2450);
	}
	

}
