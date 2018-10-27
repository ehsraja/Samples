package com.rhl.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.rhl.ReportManger;
import com.rhl.domain.Report;

public class Demo {
	  
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Report report = new Report.ReportBuilder("Sample").with("Ticker","TimeIN","Timeout","timetoCompute","Num of trades").build();
			ReportManger manger = new ReportManger(report);
	
	
	public void demoMethod(int numofTrades) throws InterruptedException {
		
		Date timeIn = new Date ();
		System.out.println("complex task ");
		Thread.sleep(1000);
		Date timeout = new Date();
		manger.capture("TURKEY",sdf.format(timeIn),sdf.format(timeout),(timeout.getTime()-timeIn.getTime()),numofTrades);
	}

}
