import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

import {  MatDialogRef } from "@angular/material/dialog";
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {
  // form!: FormGroup;
  constructor(private _service: CategoryService,private formBuilder:FormBuilder,private dialogRef: MatDialogRef<AddCategoryComponent>,
  ) { }
 newCategory:any;
 name='';
  ngOnInit(): void {
   
  }
 save(){
    this.newCategory={
      name:this.name,
    }
    this._service.addCategory(this.newCategory).subscribe(
      (data)=>{
        Swal.fire('success!!!','Category added successfully','success');
        this.dialogRef.close();
      },
      (error)=>
      {
        Swal.fire('error');
      }
    )
    console.log(this.newCategory);
 }
 close(){
   this.dialogRef.close();
 }
}
