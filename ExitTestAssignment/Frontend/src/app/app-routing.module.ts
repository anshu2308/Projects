import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerHomeComponent } from './pages/customer/customer-home/customer-home.component';
import { ImageComponent } from './pages/customer/image/image.component';
import { ProductCategoriesComponent } from './pages/customer/product-categories/product-categories.component';
import { ProductsComponent } from './pages/customer/products/products.component';
import { PurchaseComponent } from './pages/customer/purchase/purchase.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { CategoriesComponent } from './pages/vendor/categories/categories.component';
import { SaveproductComponent } from './pages/vendor/saveproduct/saveproduct.component';
import { ShowproductsComponent } from './pages/vendor/showproducts/showproducts.component';
import { UpdateProductComponent } from './pages/vendor/update-product/update-product.component';
import { VendorHomeComponent } from './pages/vendor/vendor-home/vendor-home.component';
import { WelcomeComponent } from './pages/vendor/welcome/welcome.component';
import { CustomerGuard } from './services/customer.guard';
import { VendorGuard } from './services/vendor.guard';

const routes: Routes = [
  { path: 'signup/:id', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  { path: '', component: LoginComponent },
  {
    path: 'vendor', component: VendorHomeComponent, canActivate: [VendorGuard],
    children: [
      { path: 'profile', component: ProfileComponent },
      { path: '', component: WelcomeComponent },
      { path: 'categories', component: CategoriesComponent },
      { path: 'products', component: ShowproductsComponent },
      { path: 'save-product', component: SaveproductComponent },
      { path: 'update-product/:id', component: UpdateProductComponent }
    ]
  },
  {
    path: 'customer', component: CustomerHomeComponent, canActivate: [CustomerGuard],
    children: [{ path: 'profile', component: ProfileComponent },
    { path: 'products', component: ProductsComponent },
      { path: 'categories', component: ProductCategoriesComponent },

    { path: 'purchase/:id', component: PurchaseComponent }]
  },
  
  {path:'image',component:ImageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
