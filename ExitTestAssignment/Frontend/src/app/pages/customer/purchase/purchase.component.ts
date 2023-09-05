import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import { SoldService } from 'src/app/services/sold.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit {

  // public purchaseForm!: FormGroup;
 
  date:any;
  today = (new Date()).toISOString().substring(0, 10);
  purchasedProduct: any;
  location:any;
  currentuser=JSON.parse(localStorage.getItem('user') || '{}');
  purchaseDetails :any;
//    [
//   {
//     date: this.today,
//     product: {
//       id:'1',
//     },
//     customer: {
//       id:1,
//     },
//     seller: {
//       id:1,
//     },
//     location: 'Lucknow'
//   }
// ]
  id = 0;

  constructor(private _snack: MatSnackBar,private _formBuilder: FormBuilder, private _product: ProductService, private _activatedroute: ActivatedRoute,private _sold:SoldService, private _router: Router,public datepipe: DatePipe) { 
    
  }
  
  ngOnInit(): void {
    this.date= this.datepipe.transform(this.today);
    this.id = this._activatedroute.snapshot.params.id;
    this._product.getProductById(this.id).subscribe(
      (data: any) => {
        this.purchasedProduct = data;
        console.log(data);
      },
      (error) => {
        Swal.fire('error!!', 'cannot load data', 'error');
        // console.log(error);
      });
    // this._sold.getSoldBySeller(1).subscribe(
    //   (data)=>{
    //     console.log(data);
    //   }
    // )
    // this.purchaseForm = this._formBuilder.group({
    //   pName: [''],
    //   pCode: [''],
    //   pDescription: [''],
    //   date:[''],
    //   price:[''],
    //   customer: [''],
    //   location: ['', Validators.required],
    // });
    
   
  }
  purchase() {
    this.purchaseDetails = 
      {
        date: new Date(),
        product:this.purchasedProduct,
        // customer:this.currentuser,
        location: this.location
      }
    
    console.log(this.purchaseDetails);
    if (this.purchaseDetails.location != null || this.purchaseDetails.location==''){
  this._sold.addSoldProduct(this.purchaseDetails).subscribe(
    (data) => {
      Swal.fire('Success!!', 'Purchase Confirmed', 'success');
      this._router.navigate(['/customer/products']);

    },
    (error) => {
      Swal.fire('error!!', 'cannot save data', 'error');
      console.log(error);
      this._router.navigate(['/customer/products']);
    });
}
else{
  this._snack.open("Location is required!!!" ,'ok',{
    duration:3000
  });
}
     }
}
