import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ProductService } from 'src/app/services/product.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-showproducts',
  templateUrl: './showproducts.component.html',
  styleUrls: ['./showproducts.component.css']
})
export class ShowproductsComponent implements OnInit {
products=[
  {
    id: 1,
    pName: "AncjsncknS",
    pCode: "df32u89r",
    pDescription: "cndzkjvn",
    costPrice: 8489,
    discount: 20,
    category: {
      name:'a',
    },
    image:'',
    price: 1
  },

]
  constructor(private _rout:Router,private _productService:ProductService) { }

  ngOnInit(): void {
   this.getProducts();
  }
getProducts(){
  this._productService.getAllproducts().subscribe(
    (data) => {
      this.products = data;
      console.log(this.products);
    },
    (error) => {
      console.log(error);
      Swal.fire('Error!', "Error in loading data", 'error');
    }
  );
}
delete(id:any){
  console.log(id);
  this._productService.deleteProduct(id).subscribe(
    (data)=>{
      Swal.fire('success!!',"Item deleted successfully",'success');
this.getProducts();
    },
    (error)=>{
      Swal.fire("error", "Error in deleting data", 'error');
    }
  );
 
}

}
