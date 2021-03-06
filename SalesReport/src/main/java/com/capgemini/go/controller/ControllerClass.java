package com.capgemini.go.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.entity.RevenueTable;
import com.capgemini.go.service.ServiceInterface;

@RestController
@RequestMapping("/Reports")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceInterface serviceobj;

	// Get SalesReports
	@GetMapping("/SalesReport/{date1}/{date2}/{userid}/{category}")
	private ResponseEntity<List<RevenueTable>> viewSalesReportByUserAndCategory(@PathVariable("date1") String entry,
			@PathVariable("date2") String exit, @PathVariable("userid") String targetUserId,
			@PathVariable("category") String category) {
		System.out.println(entry + exit + targetUserId + category);
		List<RevenueTable> saleslist = serviceobj.viewSalesReportByUserAndCategory(entry, exit, targetUserId, category);
		return new ResponseEntity<List<RevenueTable>>(saleslist, HttpStatus.OK);
	}

}
