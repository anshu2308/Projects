import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';
import { PurchaseComponent } from '../purchase/purchase.component';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  search:string | undefined ;
  products = [
    {
      id: 1,
      pName: "AncjsncknS",
      pCode: "df32u89r",
      pDescription: "cndzkjvn",
      costPrice: 8489,
      discount: 20,
      price:1,
      category: {
        name: 'dd',
      },
      image: ''
    },


  ]
 
  constructor(private _productService: ProductService, private _dialog: MatDialog,) { }

  ngOnInit(): void {
    this._productService.getAllproducts().subscribe(
      (data: any) => {
        this.products = data;
        console.log(this.products);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error!', "Error in loading data", 'error');
      }
    );
  }

}
