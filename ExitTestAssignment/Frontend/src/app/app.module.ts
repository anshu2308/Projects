import { NgModule } from '@angular/core';
import { DatePipe } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { MatButtonModule } from '@angular/material/button';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { VendorHomeComponent } from './pages/vendor/vendor-home/vendor-home.component';
import { SaveproductComponent } from './pages/vendor/saveproduct/saveproduct.component';
import { MatDialogModule } from '@angular/material/dialog';
import { authInterceptopProviders } from './services/auth.interceptor';
import { CustomerHomeComponent } from './pages/customer/customer-home/customer-home.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { MatListModule } from '@angular/material/list';
import { SidebarComponent } from './pages/vendor/sidebar/sidebar.component';
import { WelcomeComponent } from './pages/vendor/welcome/welcome.component';
import { CategoriesComponent } from './pages/vendor/categories/categories.component';
import { ShowproductsComponent } from './pages/vendor/showproducts/showproducts.component';
import { MatSelectModule } from '@angular/material/select';
import { UpdateProductComponent } from './pages/vendor/update-product/update-product.component';
import { MenuComponent } from './pages/customer/menu/menu.component';
import { ProductsComponent } from './pages/customer/products/products.component';
import { PurchaseComponent } from './pages/customer/purchase/purchase.component';
import { ImageComponent } from './pages/customer/image/image.component';
import { SafeUrlPipe } from './safe-url.pipe';
import { ProductCategoriesComponent } from './pages/customer/product-categories/product-categories.component';
import { AddCategoryComponent } from './pages/vendor/add-category/add-category.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    VendorHomeComponent,
    SaveproductComponent,
    CustomerHomeComponent,
    ProfileComponent,
    SidebarComponent,
    WelcomeComponent,
    CategoriesComponent,
    ShowproductsComponent,
    UpdateProductComponent,
    MenuComponent,
    ProductsComponent,
    PurchaseComponent,
    ImageComponent,
    SafeUrlPipe,
    ProductCategoriesComponent,
    AddCategoryComponent,
   

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatListModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [authInterceptopProviders, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
