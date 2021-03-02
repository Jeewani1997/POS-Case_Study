import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CustomerModel } from '../../Module/Customer';
import { ItemModel } from '../../Module/Item';
import { OrderService } from '../../Service/order.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialogConfig, MatDialog, MatPaginator } from '@angular/material';
import { Router, ActivatedRoute } from '@angular/router';
import { OrderModel } from '../../Module/Order';
import { OrderDataModel } from '../../Module/OrderData';
import { AlertComponent } from '../../alert/alert.component';


@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  displayedColumnsCustomer = ['name', 'adress', 'mobile', 'table-edit', 'table-remove'];
  customerView: CustomerModel[] = new Array();
  dataSourceCustomer = new MatTableDataSource<CustomerModel>(this.customerView);
  arra: OrderDataModel[] = new Array();

  editObject = null;
  editDocumentPid: string;
  addType: String = "Save";
  customerArray: Array<any> = new Array();
  itemArray: Array<any> = new Array();
  array: Array<any> = new Array();
  orderData: OrderDataModel[] = new Array();
  dataSourceOrder = new MatTableDataSource<OrderDataModel>(this.orderData);
  displayedColumnsOrder = ['itemName', 'qtity', 'discount', 'remove']
  total: any;
  approve: boolean = false;
  //f:any


  constructor(private orderService: OrderService, private router: Router, private route: ActivatedRoute, public dialog: MatDialog) {
    this.route.params.subscribe(params => {
      this.editDocumentPid = params.data

    });
  }

  ngOnInit() {
    this.loadCustomer();
    this.getAllCustomer();
    this.getAllItem();



  }

  validateDis() {
    if (this.Discount.value > 100) {
      alert("Discount can't greater than 100")
      this.Discount.invalid;
      this.Discount.reset();
    }
  }


  customerForm = new FormGroup({
    name: new FormControl("", Validators.required),
    adress: new FormControl("", Validators.required),
    mobile: new FormControl('', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]),
  })

  get Name() {
    return this.customerForm.get("name");
  }
  get Adress() {
    return this.customerForm.get("adress");
  }
  get Mobile() {
    return this.customerForm.get("mobile");
  }



  itemForm = new FormGroup({
    itemName: new FormControl("", Validators.required),
    unitPrice: new FormControl("", Validators.required),
    itemQnt: new FormControl("", Validators.required),
  })

  get ItemName() {
    return this.itemForm.get("itemName");
  }
  get UnitPrice() {
    return this.itemForm.get("unitPrice");
  }
  get ItemQnt() {
    return this.itemForm.get("itemQnt");
  }

  orderForm = new FormGroup({
    customer: new FormControl("", Validators.required),
  })

  get Customer() {
    return this.orderForm.get("customer");
  }

  orderDataForm = new FormGroup({
    item: new FormControl("", Validators.required),
    qtity: new FormControl("", Validators.required),
    discount: new FormControl("")
  })

  get Item() {
    return this.orderDataForm.get("item");
  }

  get Qtity() {
    return this.orderDataForm.get("qtity");
  }

  get Discount() {
    return this.orderDataForm.get("discount");
  }

  SaveCustomer() {
    //console.log(this.editDocumentPid)

    if (this.customerForm.valid) {
      let customer = new CustomerModel();
      customer.Name = this.Name.value;
      customer.Adress = this.Adress.value;
      customer.Mobile = this.Mobile.value;
      console.log(customer);

      this.orderService.saveCustomer(customer).subscribe(response => {
        console.log(response)

        if (response == 200) {
          console.log("success")
          alert('Successfully Saved')
          this.clearCustomer();
          this.router.navigate(['viewCustomer']);
        } else {

          alert("Error")
        }
      }, err => {

        alert("Error");
      }
      );

    } else {
      alert("Fill All Required Data")
    }


  }

  SaveItem() {
    if (this.itemForm.valid) {
      let item = new ItemModel();
      item.Name = this.ItemName.value;
      item.Qtity = this.ItemQnt.value;
      item.UPrice = this.UnitPrice.value;
      console.log(item);

      this.orderService.saveItem(item).subscribe(response => {
        console.log(response)

        if (response == 200) {
          console.log("success")
          alert('Successfully Saved')
          this.clearItem();
          this.router.navigate(['viewCustomer']);
        } else {

          alert("Error")
        }
      }, err => {

        alert("Error");
      }
      );

    } else {
      alert("Fill All Required Data")
    }
  }

  clearCustomer() {
    this.customerForm.reset();
  }

  clearItem() {
    this.itemForm.reset();
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
      // this.loading_form = false;
      // this.alert("Oopz...", "Error occour at Loading Pending Request", "error");
    }
    )

  }

  edit(customer: CustomerModel) {
    console.log(customer.PId)
    this.router.navigate(['editCustomer/' + customer.PId]);
  }

  getAllCustomer() {
    this.orderService.getCustomer().subscribe(response => {

      this.customerArray = new Array();
      for (let i in response) {
        let e = response[i];
        console.log(response[i])
        let cus: CustomerModel = new CustomerModel();

        cus.PId = e.pId;
        cus.Name = e.name;

        this.customerArray.push(cus);

      }
      console.log(this.customerArray)
    })

  }

  getAllItem() {
    this.orderService.getItem().subscribe(response => {

      this.itemArray = new Array();
      for (let i in response) {
        let e = response[i];
        console.log(response[i])
        let it: ItemModel = new ItemModel();

        it.PId = e.pId;
        it.Name = e.name;
        it.UPrice = e.uPrice;

        this.itemArray.push(it);

      }
      console.log(this.itemArray)
    })

  }

  AddItemToCart() {
    if (this.orderDataForm.valid) {

      let orderDataModel = new OrderDataModel();

      if (this.orderData.length != 0) {

        let e = this.orderData.findIndex(i => (i.Item == this.Item.value))
        if (e >= 0) {
          alert("Already exist");
          this.clearOrderData();
        } else {
          orderDataModel.Item = this.Item.value;
          orderDataModel.Qtity = this.Qtity.value;
          orderDataModel.Discount = this.Discount.value;

          this.orderService.getItemById(this.Item.value).subscribe(response => {
            if (response[0].qtity < orderDataModel.Qtity) {
              alert("Out Of Stock")
              this.clearOrderData();
            } else {
              let i = response[0].uPrice
              let j = response[0].qtity
              let k = response[0].name
              orderDataModel.ItemName = k;
              let a = (Number(orderDataModel.Qtity) * Number(i) * (Number(orderDataModel.Discount) / 100)).toString();
              orderDataModel.Stotal = ((Number(orderDataModel.Qtity) * Number(i)) - Number(a)).toString();
              orderDataModel.Ttotal = (Number(orderDataModel.Qtity) * Number(i)).toString();
              orderDataModel.Fqtity = (Number(j) - Number(orderDataModel.Qtity)).toString();
              this.clearOrderData();
              this.orderData.push(orderDataModel);
              this.dataSourceOrder.data = null;
              this.dataSourceOrder.data = this.orderData;

            }
          })


        }

      } else {
        orderDataModel.Item = this.Item.value;
        orderDataModel.Qtity = this.Qtity.value;
        orderDataModel.Discount = this.Discount.value;

        this.orderService.getItemById(this.Item.value).subscribe(response => {
          console.log(response[0])
          if (response[0].qtity < orderDataModel.Qtity) {
            alert("Out Of Stock")
            this.clearOrderData();
          } else {
            let i = response[0].uPrice
            let j = response[0].qtity
            let k = response[0].name
            orderDataModel.ItemName = k;
            let a = (Number(orderDataModel.Qtity) * Number(i) * (Number(orderDataModel.Discount) / 100)).toString();
            orderDataModel.Stotal = ((Number(orderDataModel.Qtity) * Number(i)) - Number(a)).toString();
            orderDataModel.Ttotal = (Number(orderDataModel.Qtity) * Number(i)).toString();
            orderDataModel.Fqtity = (Number(j) - Number(orderDataModel.Qtity)).toString();
            this.clearOrderData();
            this.orderData.push(orderDataModel);
            this.dataSourceOrder.data = null;
            this.dataSourceOrder.data = this.orderData;
          }
        })



      }
    }
    else {
      alert("Error")
    }

  }


  remove(order: any) {
    if (!this.approve) {
      this.alertconfirmation("Delete", ["Are you sure delete this"], "error", "", order);
    } else {
      this.orderData.splice(this.orderData.indexOf(order), 1);
      this.dataSourceOrder.data = this.orderData;
      this.approve = false;
    }
  }


  clearOrderData() {
    this.orderDataForm.reset();
  }

  SaveOrder() {

    let f = 0;
    let j = 0;
    if (this.orderForm.valid) {
      let order = new OrderModel();
      order.Customer = this.Customer.value;
      order.OrderDataDto = this.orderData
      console.log(this.orderData)
      // console.log(this.orderData[0])
      // console.log(this.orderData[1])

      for (let i in this.orderData) {
        console.log(this.orderData[i].Ttotal)
        f = f + Number(this.orderData[i].Ttotal)
        j = j + Number(this.orderData[i].Stotal)
      }

      console.log(f)
      console.log(j)
      order.Tamount = f.toString();
      order.Tdiscount = (f - j).toFixed(2).toString();
      console.log(order)
      if (order.OrderDataDto != null) {
        if (this.orderData.length != 0) {
          this.orderService.saveOrder(order).subscribe(response => {
            console.log(order)
            if (response == 200) {
              console.log("success")
              alert('Successfully Placed A Order')
              this.orderData = this.arra;
              this.orderForm.reset();
              location.reload();
            } else {

              alert("Error")
            }
          })
        } else {
          alert("Error")
        }
      } else {
        alert("Error")
      }

    } else {
      alert("Error")
    }
  }

  alertconfirmation(title: string, message: string[], type: string, method: string, order: OrderDataModel) {
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
        this.remove(order);
      } else {
        this.approve = false;
      }

    });
  }



}
