package com.reportgeneration.controller;

import com.reportgeneration.dto.SalesReportResponse;
import com.reportgeneration.entity.Sale;
import com.reportgeneration.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@PostMapping
	public Sale addSale(@RequestBody Sale sale) {
		return reportService.saveSale(sale);
	}

	@GetMapping("/monthly")
	public ResponseEntity<?> getMonthlySales(@RequestParam int month, @RequestParam int year) {
		try {
			List<Sale> sales = reportService.getSalesForMonth(month, year);
			String filePath = reportService.generateCSVReport(month, year);

			SalesReportResponse response = new SalesReportResponse();
			response.setFilePath(filePath);
			response.setSales(sales);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
		}
	}
}