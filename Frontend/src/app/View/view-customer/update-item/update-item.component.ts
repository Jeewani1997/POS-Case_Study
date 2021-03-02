import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CustomerModel } from '../../../Module/Customer';
import { ItemModel } from '../../../Module/Item';
import { OrderService } from '../../../Service/order.service';
import { MatTableDataSource } from '@angular/material/table';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-item',
  templateUrl: './update-item.component.html',
  styleUrls: ['./update-item.component.scss']
})
export class UpdateItemComponent implements OnInit {

  editDocumentPid: string;
  customer: CustomerModel;

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

  constructor(private orderService: OrderService, private router: Router, private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.editDocumentPid = params.data

    });
  }

  ngOnInit() {

    this.orderService.getItemById(this.editDocumentPid).subscribe(response => {

      this.customer = response;
      console.log(this.customer[0])
      this.itemForm.get("itemName").setValue(this.customer[0].name);
      this.itemForm.get("unitPrice").setValue(this.customer[0].uPrice);
      this.itemForm.get("itemQnt").setValue(this.customer[0].qtity);
      console.log(this.itemForm)
    })


  }

  SaveItem() {
    console.log(this.editDocumentPid)
    if (this.itemForm.valid) {
      let item = new ItemModel();
      item.PId = this.editDocumentPid
      item.Name = this.ItemName.value;
      item.Qtity = this.ItemQnt.value;
      item.UPrice = this.UnitPrice.value;
      console.log(item);

      this.orderService.updateItem(this.editDocumentPid, item).subscribe(response => {
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
    this.itemForm.reset();
  }





}
