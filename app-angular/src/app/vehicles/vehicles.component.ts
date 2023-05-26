import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {
  vehicles: any;

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.http.get("http://localhost:8000/IMMATRICULATION-SERVICE//web/vehicles").subscribe({
      next: (data) => {
        this.vehicles = data;
      },
      error: (err) => {
      }
    });

  }
  deleteVehicle(c: any) {
    this.router.navigateByUrl("/deletevehicle/" + c.id);

  }
}


