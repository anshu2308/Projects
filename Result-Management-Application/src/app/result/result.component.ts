import { DatePipe } from '@angular/common';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css'],
  providers:[DatePipe]
})
export class ResultComponent implements OnInit {
 result!:FormGroup;
  constructor(private formBuilder: FormBuilder, @Inject(MAT_DIALOG_DATA) public Data: any, private datePipe: DatePipe) { }

  ngOnInit(): void {
    this.result = this.formBuilder.group({
      RollNo: [''],
      Name: [''],
      DOB: [''],
      Score: ['']
    });
    if (this.Data) {
      this.result.controls['RollNo'].setValue(this.Data.RollNo);
      this.result.controls['Name'].setValue(this.Data.Name);
      this.result.controls['DOB'].setValue(this.datePipe.transform(this.Data.DOB));
      this.result.controls['Score'].setValue(this.Data.Score);

    }
  }

}
