import { Component, Input, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FormValidations } from '../../form-validations';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss']
})
export class MessagesComponent implements OnInit {

  @Input()
  message: string = '';
  @Input()
  control: FormControl | undefined;
  constructor() { }

  ngOnInit(): void {
  }

  get errorMessage() {

    for (const propertyName in this.control?.errors) {
      if (this.control?.errors.hasOwnProperty(propertyName) &&
        this.control.touched) {
          return FormValidations.getErrorMsg(this.message, propertyName, this.control.errors[propertyName])
        }
    }
    return null;
  }

}
