import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FindResultComponent } from './find-result/find-result.component';
import { LoginBtnComponent } from './login-btn/login-btn.component';
import { AdminComponent } from './login/admin.component';
import { StLoginComponent } from './st-login/st-login.component';
import { TeacherComponent } from './teacher/teacher.component';

const routes: Routes = [
  {path:'admin',component:AdminComponent},
    {path:'student',component:StLoginComponent},
  { path: 'teacher', component: TeacherComponent },
  { path: 'findresult' ,component:FindResultComponent},
  {path:'',component:LoginBtnComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
