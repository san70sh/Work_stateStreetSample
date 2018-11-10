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
	Product product;
	Map<String, Product> productMap = new HashMap<String, Product>();

	public void loadPrices() {
		String fileRow = "";
		File priceDetails = new File("../sampleProject/src/main/resources/pricing.txt");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(priceDetails));

			while ((fileRow = br.readLine()) != null) {
				List<String> detailList = Arrays.asList(fileRow.split(";"));

				for (int i = 0; i < detailList.size(); i++) {
					List<String> productdetails = Arrays.asList(detailList.get(i).split(","));

					if (productdetails.size() == 5) {
						product = new Product(productdetails.get(0), Float.parseFloat(productdetails.get(1)),
								productdetails.get(2), Float.parseFloat(productdetails.get(3)),
								Integer.parseInt(productdetails.get(4)));
					} else {
						product = new Product(productdetails.get(0), Float.parseFloat(productdetails.get(1)), "NA",
								Float.parseFloat(productdetails.get(1)), 1);
					}
					productMap.put(productdetails.get(0), product);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {

			}
		}

	}

	public void scan(String nextProduct) {
		if (productMap.get(nextProduct) == null) {
			System.out.println("Product does not exist.");
		} else {
			totalPrice += this.updatePrice(productMap, nextProduct);
			System.out.println("Item added.");
			System.out.printf("Current bill is $%.2f", totalPrice);
			System.out.println();
		}

	}

	private float updatePrice(Map<String, Product> productMap, String nextProduct) {

		Product currProduct = productMap.get(nextProduct);
		if (currProduct.getQty()-currProduct.getCount()> 1) {
			currProduct.setCount(currProduct.getCount() + 1);
			return currProduct.getUnitPrice();
		} else {
			if (currProduct.getVolume().equals("V")) {
				float corr = currProduct.getVolPrice()
						- currProduct.getCount() * currProduct.getUnitPrice();
				currProduct.setCount(0);
				return corr;
			} else {
				if (currProduct.getQty() - currProduct.getCount() == 1) {
					float corr = currProduct.getQty() * currProduct.getUnitPrice()
							- currProduct.getCount() * currProduct.getUnitPrice();
					currProduct.setCount(currProduct.getCount() + 1);
					return corr;
				} else {
					return currProduct.getVolPrice();
				}

			}
		}
	}

}
