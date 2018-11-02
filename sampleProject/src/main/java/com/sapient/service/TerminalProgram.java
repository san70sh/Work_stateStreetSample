package com.sapient.service;

import java.util.Scanner;

public class TerminalProgram {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		PointOfSaleTerminal terminal = new PointOfSaleTerminal();
		
		terminal.loadPrices();
		
		System.out.print("Please enter item: ");
		boolean fin = false;
		while(!fin) {
			String nextProduct = sc.next();
			if(nextProduct.equals("E")) {
				fin = true;
			} else {
				terminal.scan(nextProduct);
				System.out.println("Please enter next item: ");
			}
		}
		sc.close();
		
		System.out.printf("Total checkout cost: $%.2f", terminal.totalPrice);
	}
}
