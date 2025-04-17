package com.reportgeneration.dto;

import com.reportgeneration.entity.Sale;
import java.util.List;

public class SalesReportResponse {
	private String filePath;
	private List<Sale> sales;

	// Getters and setters
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}
}