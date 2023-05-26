import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-delete-vehicle',
  templateUrl: './delete-vehicle.component.html',
  styleUrls: ['./delete-vehicle.component.css']
})
export class DeleteVehicleComponent implements  OnInit {
  vehicleId!: string;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {
    this.vehicleId = route.snapshot.params['vehicleId'];
  }
  ngOnInit(): void {
    const url = `http://localhost:8000/IMMATRICULATION-SERVICE/web/vehicles/${this.vehicleId}`;

    this.http.delete(url).subscribe({
      next:()=>{
        this.router.navigate(['/vehicles'])
      },
      error:(err)=>{}
    });


  }
}
