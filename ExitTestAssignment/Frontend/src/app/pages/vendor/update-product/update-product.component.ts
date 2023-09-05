import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  productForm !: FormGroup;
  constructor(private _snack: MatSnackBar,private _formBuilder:FormBuilder,private _route: ActivatedRoute,private _router:Router, private _product: ProductService, private _categories:CategoryService) { }
  id=0;
  product: any;
  categories:any;
  ngOnInit(): void {
this.id=this._route.snapshot.params.id;
   this._product.getProductById(this.id).subscribe( 
   (data:any)=>
   {
     this.product = data;
     console.log(data);
   },
   (error)=>{
    console.log(error);
   });
    this._categories.getcategories().subscribe((data: any) => {
      this.categories = data;
      console.log(this.categories);
    },
      (error) => {
        console.log(error);
        Swal.fire("Error!!", "error in loading data", 'error');
      });
    this.productForm = this._formBuilder.group({

      pName: new FormControl('', [Validators.required]),
      pDescription: new FormControl('', [Validators.required]),
      pCode: new FormControl('', [Validators.required]),
      costPrice: new FormControl('', [Validators.required, Validators.pattern('[0-9]+$')]),
      discount: new FormControl('', [Validators.required, Validators.pattern('[0-9]+$'), Validators.max(99)]),
      category: new FormControl('', [Validators.required])
    });
  }
updateProduct(){
  if (this.productForm.valid ) {
  
   this._product.editProduct(this.product).subscribe(
    (data)=>{
      Swal.fire('Success!!','Product details are updated','success');
      this._router.navigate(['vendor/products']);
    },
    (error)=>{
      Swal.fire('Error!!', 'Error in updating details', 'error');
    }
  
  )
  }
  else {
    this._snack.open("Please fill all the required fields!!!", '', {
      duration: 3000,
    })
}
}
}
