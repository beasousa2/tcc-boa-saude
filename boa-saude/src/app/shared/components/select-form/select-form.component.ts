import { Component, OnInit } from '@angular/core';
import { faL } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-select-form',
  templateUrl: './select-form.component.html',
  styleUrls: ['./select-form.component.scss']
})
export class SelectFormComponent implements OnInit {
  active!: Boolean;

  constructor() { }

  ngOnInit(): void {
    this.active = false
  }

  activeDropdown() {
    this.active = true;
  }

  close() {
    this.active = false;
  }

}
