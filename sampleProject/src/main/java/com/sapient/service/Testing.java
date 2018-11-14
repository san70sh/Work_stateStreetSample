package com.sapient.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.models.Product;



public class Testing {
	
	

	public static void main(String[] args) {
		
		Map<String, Product> orderList = new HashMap<String, Product>();
		
		
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
				
				for (Product values : orderList.values()) {
					System.out.println(values);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
