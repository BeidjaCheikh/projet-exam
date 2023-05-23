import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-deleteinfraction',
  templateUrl: './deleteinfraction.component.html',
  styleUrls: ['./deleteinfraction.component.css']
})
export class DeleteinfractionComponent implements  OnInit {
  infractionId!: string;
  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {
    this.infractionId = route.snapshot.params['infractionId'];
  }
  ngOnInit(): void {
    const url = `http://localhost:8000/INFRACTION-SERVICE/web/infractions/${this.infractionId}`;

    this.http.delete(url).subscribe({
      next:()=>{
        this.router.navigate(['/infractions'])
      },
      error:(err)=>{}
    });


  }
}
