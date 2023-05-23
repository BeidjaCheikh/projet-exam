import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: 'app-vehiclowner',
  templateUrl: './vehiclowner.component.html',
  styleUrls: ['./vehiclowner.component.css']
})
export class VehiclownerComponent implements OnInit {
  vehicles: any;
  ownerId!: string;

  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {
    this.ownerId = route.snapshot.params['ownerId'];
  }

  ngOnInit(): void {
    this.http.get(`http://localhost:8000/IMMATRICULATION-SERVICE//web/owners/${this.ownerId}/vehicles`).subscribe({
      next: (data) => {
        this.vehicles = data;
      },
      error: (err) => {
        // Gérer l'erreur ici
      }
    });
  }
}
