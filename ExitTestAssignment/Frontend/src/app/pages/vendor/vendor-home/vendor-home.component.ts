import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';
// import { SaveproductComponent } from 'src/app/pages/vendor/saveproduct/saveproduct.component';
@Component({
  selector: 'app-vendor-home',
  templateUrl: './vendor-home.component.html',
  styleUrls: ['./vendor-home.component.css']
})
export class VendorHomeComponent implements OnInit {

  constructor(private _product:ProductService) { }

  ngOnInit(): void {
  }

  // openProductDialog() {
  //   this._dialog.open(SaveproductComponent, {
  //     width: '30%'
  //   })
  // }
  retrievedImage: any;
  base64Data: any;
  openEditDialog() {
    // this._product.getProductById(27).subscribe(
    //   (data)=>{
    //     this.base64Data=data.image;
    //     this.retrievedImage = 'data: image / jpeg; base64, ' + this.base64Data;
    //   }
    // )
    // this._product.getAllproducts().subscribe(
    //   (data) => {
    //    this.base64Data = data.image;
    //     this.retrievedImage = 'data: image / jpeg; base64, ' + this.base64Data;
    //   },(error)=>{
    //     Swal.fire('Error!', "Error in loading data", 'error');
    //   });
  
}}
