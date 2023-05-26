import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-dele-owner',
  templateUrl: './dele-owner.component.html',
  styleUrls: ['./dele-owner.component.css']
})
export class DeleOwnerComponent implements  OnInit {
  ownerId!: string;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {
    this.ownerId = route.snapshot.params['ownerId'];
  }
  ngOnInit(): void {
    const url = `http://localhost:8000/IMMATRICULATION-SERVICE/web/owners/${this.ownerId}`;

    this.http.delete(url).subscribe({
      next:()=>{
        this.router.navigate(['/owners'])
      },
      error:(err)=>{}
    });





  }

}
