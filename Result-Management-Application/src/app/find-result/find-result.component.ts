import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import { ResultComponent } from '../result/result.component';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-find-result',
  templateUrl: './find-result.component.html',
  styleUrls: ['./find-result.component.css']
})
export class FindResultComponent implements OnInit {
  public searchForm!: FormGroup;
  public id: number | undefined;
  constructor(private dialog: MatDialog, private formBuilder: FormBuilder, private http: HttpClient, private api: ApiService) { }

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      RollNo: ['', [Validators.required,Validators.pattern('[0-9]+$')]],
      Name: ['', Validators.required]
    })
  }
  search() {

    this.api.getResult()
      .subscribe(res => {
        const user = res.
          find((a: any) => {
            this.id = a.id;
            return a.Name === this.searchForm.value.Name && a.RollNo === this.searchForm.value.RollNo
          })
        if (user) {
          this.http.get<any>("http://localhost:3000/ResultList/" + this.id)
            .subscribe(res => {
              this.showResult(res);
            });
        }
        else{
          alert("No such result");
        };
      }, err => {
        alert("something went wrong!!")
      })
  }
  showResult(row: any) {
    this.dialog.open(ResultComponent, {
      width: '30%',
      data: row
    })
  }
  get rollNo(){
return this.searchForm.get('RollNo');
  }
}
