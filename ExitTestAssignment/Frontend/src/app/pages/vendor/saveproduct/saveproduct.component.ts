import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';
import { User } from 'src/app/user';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-saveproduct',
  templateUrl: './saveproduct.component.html',
  styleUrls: ['./saveproduct.component.css']
})
export class SaveproductComponent implements OnInit {

  productForm !: FormGroup;
  categories = [
    {
      cid: 1,
      name: 'Cloth',
    }
  ]
  currentuser = JSON.parse(localStorage.getItem('user') || '{}');
  productData = {
    pName: '',
    pCode: '',
    pDescription: '',
    costPrice: '',
    discount: '',
     user: this.currentuser,
    price: 0,
    category: {
      cid: '',
    },

  };
  constructor(private _route:Router,private _categories: CategoryService, private _formBuilder: FormBuilder, private _productService: ProductService, private _snack: MatSnackBar) { }
  // public selectedFile: any;
  uploadedImage: File;
  imgURL: any;
  ngOnInit(): void {
    this._categories.getcategories().subscribe((data: any) => {
      this.categories = data;
      // console.log(this.categories);
    },
      (error) => {
        console.log(error);
        Swal.fire("Error!!", "error in loading data", 'error');
      });
      this.productForm=this._formBuilder.group({
        
        pName:new FormControl('',[Validators.required]),
        pDescription: new FormControl('', [Validators.required]),
        pCode: new FormControl('', [Validators.required]),
        costPrice: new FormControl('', [Validators.required, Validators.pattern('[0-9]+$')]),
        discount: new FormControl('', [Validators.required, Validators.pattern('[0-9]+$'),Validators.max(99)]),
        category: new FormControl('', [Validators.required])
      });
  }
  addProduct() {
    if (this.productForm.valid && this.uploadedImage!=null) {
    // console.log(localStorage.getItem('user'));
    console.log(this.productData);
    
    const formData = new FormData();
    formData.append('product', new Blob([JSON.stringify(this.productData)], { type: 'application/json' }));
    formData.append('image', this.uploadedImage);
    console.log(formData);
    this._productService.addProduct(formData).subscribe(
      data => {
        console.log(data);
        Swal.fire('Successfully done!!', 'Product is added with id' + data.id, 'success');
        this._route.navigate(['/vendor/products']);
      },
      error => {
        console.log(error);
        this._snack.open("Product already exist!!", '', {
          duration: 3000,
        })
      });
    }
    else{
      this._snack.open("Please fill all the required fields!!!", '', {
        duration: 3000,
      });
    }
  }
  public onImageUpload(event: any) {
    this.uploadedImage = event.target.files[0];
    console.log(this.uploadedImage);

  }

}
