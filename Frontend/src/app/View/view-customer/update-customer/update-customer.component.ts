import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CustomerModel } from '../../../Module/Customer';
import { OrderService } from '../../../Service/order.service';
import { MatTableDataSource } from '@angular/material/table';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.scss']
})
export class UpdateCustomerComponent implements OnInit {

  editDocumentPid: string;
  customer: CustomerModel;

  constructor(private orderService: OrderService, private router: Router, private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.editDocumentPid = params.data

    });
  }

  ngOnInit() {

    this.orderService.getCustomerById(this.editDocumentPid).subscribe(response => {

      this.customer = response;
      console.log(this.customer[0])
      this.customerForm.get("name").setValue(this.customer[0].name);
      this.customerForm.get("adress").setValue(this.customer[0].adress);
      this.customerForm.get("mobile").setValue(this.customer[0].mobile);
      console.log(this.customerForm)
    })


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

  SaveCustomer() {
    console.log(this.editDocumentPid)
    if (this.customerForm.valid) {
      let customer = new CustomerModel();
      customer.PId = this.editDocumentPid
      customer.Name = this.Name.value;
      customer.Adress = this.Adress.value;
      customer.Mobile = this.Mobile.value;
      console.log(customer);

      this.orderService.updateCustomer(this.editDocumentPid, customer).subscribe(response => {
        console.log(response)

        if (response == 200) {
          console.log("success")
          alert('Successfully Updated')
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


  clearCustomer() {
    this.customerForm.reset();
  }

}
