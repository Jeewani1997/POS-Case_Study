
import { Component, OnInit, ViewChild } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';

import { MatDialogConfig, MatDialog, MatTableDataSource, MatPaginator } from '@angular/material';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'pos-system';
}
