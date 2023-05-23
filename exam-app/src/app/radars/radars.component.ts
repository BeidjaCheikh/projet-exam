import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-radars',
  templateUrl: './radars.component.html',
  styleUrls: ['./radars.component.css']
})
export class RadarsComponent implements OnInit {
  radars:any;
  constructor(private http:HttpClient , private  router: Router) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8000/RADAR-SERVICE/web/radars").subscribe({
      next:(data)=>{
        this.radars=data;
      },
      error:(err)=>{}
    });

  }
  deleteRadar(c: any) {
    this.router.navigateByUrl("/deleteradar/" + c.id);

  }


}
