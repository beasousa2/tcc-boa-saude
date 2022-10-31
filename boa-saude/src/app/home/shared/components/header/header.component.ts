import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  toggle!: Boolean;

  constructor() { }

  ngOnInit(): void {
    this.toggle = true;
  }

  on() {
    this.toggle = true;
  }

  off() {
    this.toggle = false;
  }

}
