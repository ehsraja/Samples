package com.rhl.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhl.domain.Report;

@Service("reportService")
public class ReportService {
	
	Map<String,Report> reports = new ConcurrentHashMap<String,Report>();
	
	@Autowired
	private ReportService reportService ; 
	
	
	
   public void addReport(String reportName, List<String> header) {
		Report report = new Report.ReportBuilder("Sample").withHeader(header).build();
		reports.put(reportName, report);
	}
   
   public void addReport(Report report) {
		
		reports.put(report.getName(), report);
	}
	
	public void updateReport(String name, Map<String,Object> row) {
		reports.get(name).addRow(row);
	}
	
	
	public Set<String> getAllReports() {
		return reports.keySet();
	}
	
	public List<Map<String,Object>> getReportRows(String reportName) {
		return reports.get(reportName).getAllRows();
	}
	
	public List<String> getReportHeader(String reportName) {
		return reports.get(reportName).getheader();	}

}
