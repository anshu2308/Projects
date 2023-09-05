import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';
import { MatDialog } from '@angular/material/dialog';
import { AddCategoryComponent } from '../add-category/add-category.component';
@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  categories=[{
    cid:1,
    name:'Shoes'
  }

  ]
  constructor(private _dialog:MatDialog ,private _categories:CategoryService) { }

  ngOnInit(): void {
   this.getCategories();
  }
  getCategories(){
    this._categories.getcategories().subscribe((data: any) => {
      this.categories = data;
      console.log(this.categories);
    },
      (error) => {
        console.log(error);
        Swal.fire("Error!!", "error in loading data", 'error');
      })
  }
  openDialog() {
    this._dialog.open(AddCategoryComponent, {
      width: '30%'
    }).afterClosed().subscribe(val=>
      {
        this.getCategories();
      });
  }
}
