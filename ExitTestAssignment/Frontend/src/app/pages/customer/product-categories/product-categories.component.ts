import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-categories',
  templateUrl: './product-categories.component.html',
  styleUrls: ['./product-categories.component.css']
})
export class ProductCategoriesComponent implements OnInit {

  categories = [{
    cid: 1,
    name: 'Shoes'
  }

  ]
  constructor(private _categories: CategoryService) { }

  ngOnInit(): void {
    this._categories.getcategories().subscribe((data: any) => {
      this.categories = data;
      console.log(this.categories);
    },
      (error) => {
        console.log(error);
        Swal.fire("Error!!", "error in loading data", 'error');
      })
  }

}