import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-deleteradar',
  templateUrl: './deleteradar.component.html',
  styleUrls: ['./deleteradar.component.css']
})
export class DeleteradarComponent implements  OnInit {
  radarId!: string;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {
    this.radarId = route.snapshot.params['radarId'];
  }
  ngOnInit(): void {
    const url = `http://localhost:8000/RADAR-SERVICE/web/radars/${this.radarId}`;

    this.http.delete(url).subscribe({
      next:()=>{
        this.router.navigate(['/radars'])
      },
      error:(err)=>{}
    });


  }
}
