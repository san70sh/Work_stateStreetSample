package com.sapient.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


public class ScanandUpdateTest {
	
	private static final float EPSILON = 0.01f;
	PointOfSaleTerminal terminal = new PointOfSaleTerminal();
	float totalPrice = 0.00f, actPrice;
	
	@Test
	public void test1() {
		actPrice = 6.00f;
		
		terminal.loadPrices();
		List<String> cart1 = new ArrayList<>();
		for(int i=0; i<7;i++) {
			cart1.add("45K11");
		}
		cart1.add("E");
		for(int i=0;i<cart1.size();i++) {
			totalPrice += terminal.scan("A1");
		}
		
		assertEquals(actPrice, totalPrice, EPSILON);
	}
	
	@Test
	@Ignore
	public void test2() {
		actPrice = 1.00f;
		
		terminal.loadPrices();
		totalPrice = terminal.scan("A1");
		assertEquals(actPrice, totalPrice, EPSILON);
	}
	
	@Test
	@Ignore
	public void test3() {
		actPrice = 1.25f;
		
		terminal.loadPrices();
		totalPrice = terminal.scan("B1");
		assertEquals(actPrice, totalPrice, EPSILON);
	}

}
