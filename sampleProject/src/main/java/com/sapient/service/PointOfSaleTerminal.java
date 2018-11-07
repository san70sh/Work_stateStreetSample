package com.sapient.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.models.Product;

public class PointOfSaleTerminal {
	
	float totalPrice = 0.0f;
	
	Map<String, Product> orderList = new HashMap<String, Product>();

	public void loadPrices() {
		String fileRow = "";
		File priceList = new File("../sampleProject/src/main/resources/pricing.txt");
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(priceList));
			
			while((fileRow = br.readLine()) != null) {
				List<String> productList = Arrays.asList(fileRow.split(";"));
				Product product;
				if(productList.size() == 5) {
					product = new Product(productList.get(0),
							Float.parseFloat(productList.get(1)),
							productList.get(2),
							Float.parseFloat(productList.get(3)),
							Integer.parseInt(productList.get(4)));
				} else {
					product = new Product(productList.get(0),
							Float.parseFloat(productList.get(1)),
							"NA",
							Float.parseFloat(productList.get(1)),
							1);
				}
				orderList.put(productList.get(0), product);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(Exception e) {
				
			}
		}
		
	}

	public void scan(String nextProduct) {
		if (orderList.get(nextProduct) == null) {
			System.out.println("Product does not exist.");
		} else {
			totalPrice += this.updatePrice(orderList, nextProduct);
			System.out.println("Item added.");
			System.out.printf("Current bill is $%.2f", totalPrice);
			System.out.println();
		}
		
	}

	private float updatePrice(Map<String, Product> orderList, String nextProduct) {
		
		
		if(orderList.get(nextProduct).getQty() - orderList.get(nextProduct).getCount() > 1) {
			orderList.get(nextProduct).setCount(orderList.get(nextProduct).getCount()+1);
			return orderList.get(nextProduct).getUnitPrice();
		} else {
			if (orderList.get(nextProduct).getVolume().equals("V")){
				float corr = orderList.get(nextProduct).getVolPrice() - orderList.get(nextProduct).getCount() * orderList.get(nextProduct).getUnitPrice();
				orderList.get(nextProduct).setCount(0);
				return corr;
			} else {
				if(orderList.get(nextProduct).getQty() - orderList.get(nextProduct).getCount() == 1){
					float corr = orderList.get(nextProduct).getQty() * orderList.get(nextProduct).getUnitPrice() - orderList.get(nextProduct).getCount() * orderList.get(nextProduct).getUnitPrice();
					orderList.get(nextProduct).setCount(orderList.get(nextProduct).getCount()+1);
					return corr;
			}
				else {
					return orderList.get(nextProduct).getVolPrice();
				}
				
			}
		}
	}

}
