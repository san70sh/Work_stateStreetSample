package com.sapient.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class ScanTest {
	
	private static final double EPSILON = 0.000000001d;
	PointOfSaleTerminal terminal = new PointOfSaleTerminal();
	float expectedPrice, actPrice;
	
	@Test
	@Ignore
	public void test1() {
		actPrice = 1.25f;
		
		terminal.loadPrices();
		expectedPrice = terminal.scan("A1");
		assertEquals(actPrice, expectedPrice, EPSILON);
	}
	
	@Test
	@Ignore
	public void test2() {
		actPrice = 1.00f;
		
		terminal.loadPrices();
		expectedPrice = terminal.scan("A1");
		assertEquals(actPrice, expectedPrice, EPSILON);
	}
	
	@Test
	public void test3() {
		actPrice = 1.25f;
		
		terminal.loadPrices();
		expectedPrice = terminal.scan("B1");
		assertEquals(actPrice, expectedPrice, EPSILON);
	}

}
