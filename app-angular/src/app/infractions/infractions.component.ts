import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-infractions',
  templateUrl: './infractions.component.html',
  styleUrls: ['./infractions.component.css']
})
export class InfractionsComponent implements OnInit {
  infractions:any;
  constructor(private http:HttpClient , private  router: Router) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8000/INFRACTION-SERVICE/web/infractions").subscribe({
      next:(data)=>{
        this.infractions=data;
      },
      error:(err)=>{}
    });

  }
  deleteRadar(c: any) {
    this.router.navigateByUrl("/deleteinfraction/" + c.id);

  }
}
