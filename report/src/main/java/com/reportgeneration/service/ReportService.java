package com.reportgeneration.service;

import com.reportgeneration.entity.Sale;
import com.reportgeneration.repo.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Service
public class ReportService {

	@Autowired
	private SaleRepository saleRepository;

	public Sale saveSale(Sale sale) {
		return saleRepository.save(sale);
	}

	public List<Sale> getSalesForMonth(int month, int year) {
		LocalDate startDate = LocalDate.of(year, month, 1);
		LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
		return saleRepository.findBySalesDateBetween(startDate, endDate);
	}

	public String generateCSVReport(int month, int year) throws IOException {
		List<Sale> sales = getSalesForMonth(month, year);

		String monthName = Month.of(month).getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		String fileName = "sales_report_" + monthName + "_" + year + ".csv";
		String filePath = "./" + fileName;

		try (FileWriter writer = new FileWriter(filePath)) {
			writer.append("ID,Product ID,Product Name,Quantity Sold,Total Sales Amount,Sales Date\n");
			for (Sale sale : sales) {
				writer.append(sale.getId().toString()).append(",").append(sale.getProductId()).append(",")
						.append(sale.getProductName()).append(",").append(String.valueOf(sale.getQuantitySold()))
						.append(",").append(String.valueOf(sale.getTotalSalesAmount())).append(",")
						.append(sale.getSalesDate().toString()).append("\n");
			}
		}
		return filePath;
	}
}