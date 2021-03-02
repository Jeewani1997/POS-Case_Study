import { Component, OnInit } from '@angular/core';
import { CustomerModel } from '../../Module/Customer';
import { OrderService } from '../../Service/order.service';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ItemModel } from '../../Module/Item';
import { MatDialogConfig, MatDialog, MatPaginator } from '@angular/material';
import { AlertComponent } from '../../alert/alert.component';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.scss']
})
export class ViewCustomerComponent implements OnInit {


  displayedColumnsCustomer = ['name', 'adress', 'mobile', 'table-edit', 'table-remove'];
  customerView: CustomerModel[] = new Array();
  dataSourceCustomer = new MatTableDataSource<CustomerModel>(this.customerView);

  displayedColumnsItem = ['name', 'qtity', 'uPrice', 'table-edit', 'table-remove'];
  itemView: ItemModel[] = new Array();
  dataSourceItem = new MatTableDataSource<ItemModel>(this.itemView);
  approve: boolean = false;
  approve1: boolean = false;

  constructor(private orderService: OrderService, private router: Router, public dialog: MatDialog) { }

  ngOnInit() {
    this.loadCustomer();
    this.load();
  }

  loadCustomer() {

    this.orderService.getCustomer().subscribe(response => {

      console.log(response);
      this.customerView = new Array();
      if (response != null) {
        response.forEach(element => {

          let customer = new CustomerModel();
          customer.PId = element.pId
          customer.Name = element.name;
          customer.Adress = element.adress;
          customer.Mobile = element.mobile

          this.customerView.push(customer);

        });

        this.dataSourceCustomer.data = this.customerView;
      }
    }, error => {
      alert("Error")
     }
    )

  }

  edit(customer: CustomerModel) {
    console.log(customer.PId)
    this.router.navigate(['editCustomer/' + customer.PId]);
  }

  load() {
    this.orderService.getItem().subscribe(response => {

      console.log(response);
      this.itemView = new Array();
      if (response != null) {
        response.forEach(element => {

          let item = new ItemModel();
          item.PId = element.pId;
          item.Name = element.name
          item.Qtity = element.qtity
          item.UPrice = element.uPrice

          this.itemView.push(item);

        });

        this.dataSourceItem.data = this.itemView;
      }
    }, error => {
      alert("Error")
    
    }
    )
  }

  editItem(item: ItemModel) {
    console.log(item.PId)
    this.router.navigate(['editItem/' + item.PId]);
  }

  delete(customer: CustomerModel) {
    if (!this.approve) {
      this.alertconfirmation("Delete", ["Are you sure delete this"], "error", "", customer);
    } else {
      this.orderService.deleteCustomer(customer.PId, customer).subscribe(response => {
        if (response == '200') {
          this.router.navigate(['/viewCustomer']);
          location.reload();
        } else {
          alert("Error")
        }
      })
    }
  }

  deleteItem(item: ItemModel) {
    if (!this.approve1) {
      this.alertconfirmation1("Delete", ["Are you sure delete this"], "error", "", item);
    } else {
      this.orderService.deleteItem(item.PId, item).subscribe(response => {
        if (response == '200') {
          this.router.navigate(['/viewCustomer']);
          location.reload();
        } else {
          alert("Error")
        }
      })
    }
  }


  alertconfirmation(title: string, message: string[], type: string, method: string, customer: CustomerModel) {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: method,
      title: title,
      message: message,
      type: type
    };

    const dialogRef = this.dialog.open(AlertComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if (result.result === "yes") {

        this.approve = true;
        this.delete(customer);
      } else {
        this.approve = false;
      }

    });

  }

  alertconfirmation1(title: string, message: string[], type: string, method: string, item: ItemModel) {
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
      id: method,
      title: title,
      message: message,
      type: type
    };

    const dialogRef = this.dialog.open(AlertComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(result => {
      if (result.result === "yes") {

        this.approve1 = true;
        this.deleteItem(item);
      } else {
        this.approve1 = false;
      }

    });

  }

}
