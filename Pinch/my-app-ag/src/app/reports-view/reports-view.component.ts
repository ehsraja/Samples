import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-reports-view',
  templateUrl: './reports-view.component.html',
  styleUrls: ['./reports-view.component.scss']
})
export class ReportsViewComponent  implements OnInit {

 /* columnDefs = [
        {headerName: "ID", "field": "ID" },
        {"headerName": "TimeIN", "field": "TimeIN" },
        {"headerName": "TimeOut", "field": "TimeOut"}
    ]; */
	
	
     
 constructor(private http: HttpClient, private activeRoute: ActivatedRoute) {
	 
	

    }
	

	
    columnDefs: any; 
     rowData =  [];
	  name: ""; 
	 coldef: any;
	 row =  {
        "Num of trades": 10,
        "TimeIN": "05:45:32",
        "reportName": "Sample",
        "timetoCompute": 1000,
        "Timeout": "05:45:33",
        "Ticker": "TUUURKEY"
    };

     ngOnInit() {
		 this.activeRoute.params.subscribe(routeParams => {
		this.name = routeParams.name ;
		console.log("param name : " + this.name);
		});
		//  const name = this.activeRoute.snapshot.paramMap.get('name');
		 // console.log("param name" + name);
		 this.coldef = this.http.get('http://localhost:8080/reports/header/Sample').
		 subscribe(data => { console.log(data); 
                     		this.columnDefs = data });
		// console.log("Hi coldef " + this.coldef);
		// console.log("Hi" + this.coldef[0]);
       this.http.get('http://localhost:8080/reports/content/Sample').
	   subscribe(data => this.rowData = data);
	   this.rowData.push(this.row)
	 /*  { data.forEach ( row => {console.log(row);
	                            this.rowData.push(row);  })} 
	   ); */
		
    

}
