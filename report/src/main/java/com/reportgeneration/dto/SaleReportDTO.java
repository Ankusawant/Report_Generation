package com.reportgeneration.dto;

import java.time.LocalDate;

public class SaleReportDTO {
	private String productId;
	private String productName;
	private int quantitySold;
	private double totalSalesAmount;
	private LocalDate salesDate;

	public SaleReportDTO(String productId, String productName, int quantitySold, double totalSalesAmount,
			LocalDate salesDate) {
		this.productId = productId;
		this.productName = productName;
		this.quantitySold = quantitySold;
		this.totalSalesAmount = totalSalesAmount;
		this.salesDate = salesDate;
	}

	// Getters
	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}

	public LocalDate getSalesDate() {
		return salesDate;
	}
}
