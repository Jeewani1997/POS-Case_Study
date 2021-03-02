import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CustomerModel } from '../Module/Customer';
import { ItemModel } from '../Module/Item';
import { OrderModel } from '../Module/Order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  saveCustomer(customerModel: CustomerModel): Observable<any> {
    return this.http.post<any>("http://localhost:8090/addCustomer", customerModel);
  }

  getCustomer(): Observable<any> {
    return this.http.get<any>("http://localhost:8090/getcustomer");
  }

  getCustomerById(pId: string): Observable<any> {
    return this.http.get<any>("http://localhost:8090/getcustomer/" + pId);
  }

  saveItem(itemModel: ItemModel): Observable<any> {
    return this.http.post<any>("http://localhost:8090/addItem", itemModel);
  }

  updateCustomer(pId: string, value: any): Observable<Object> {
    return this.http.put("http://localhost:8090/editCustomer/" + pId, value);
  }

  getItem(): Observable<any> {
    return this.http.get<any>("http://localhost:8090/getitem");
  }

  getItemById(pId: string): Observable<any> {
    return this.http.get<any>("http://localhost:8090/getitem/" + pId);
  }

  updateItem(pId: string, value: any): Observable<Object> {
    return this.http.put("http://localhost:8090/editItem/" + pId, value);
  }

  saveOrder(order: OrderModel): Observable<any> {
    return this.http.post<any>("http://localhost:8090/addOrder", order);
  }

  deleteCustomer(pId: string, value: any): Observable<Object> {
    return this.http.put("http://localhost:8090/deleteCustomer/" + pId, value);
    //return this.http.put<any>("http://localhost:8090/deleteCustomer/"+pId, );
  }

  deleteItem(pId: string, value: any): Observable<Object> {
    return this.http.put("http://localhost:8090/deleteItem/" + pId, value);
    //return this.http.put<any>("http://localhost:8090/deleteCustomer/"+pId, );
  }

}
