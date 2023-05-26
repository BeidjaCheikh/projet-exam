import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent implements OnInit {
  owners:any;
  constructor(private http:HttpClient , private  router: Router) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8000/IMMATRICULATION-SERVICE//web/owners").subscribe({
      next:(data)=>{
        this.owners=data;
      },
      error:(err)=>{}
    });

  }

   getVehicles(c: any) {
  this.router.navigateByUrl("/owners-vehicles/" + c.id);

}
  deleteOwner(c: any) {
    this.router.navigateByUrl("/deleteowner/" + c.id);

  }



}
