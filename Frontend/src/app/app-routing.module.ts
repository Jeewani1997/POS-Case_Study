import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrderComponent } from './View/order/order.component';
import { ViewCustomerComponent } from './View/view-customer/view-customer.component';
import { UpdateCustomerComponent } from './View/view-customer/update-customer/update-customer.component';
import { UpdateItemComponent } from './View/view-customer/update-item/update-item.component';


const routes: Routes = [
  {
    path:'',
    component:OrderComponent,
  }  ,
  {
    path: 'editCustomer/:data',
    component: UpdateCustomerComponent,
  },
  {
    path: 'viewCustomer',
    component: ViewCustomerComponent,
  },
  {
    path: 'editItem/:data',
    component: UpdateItemComponent,
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
