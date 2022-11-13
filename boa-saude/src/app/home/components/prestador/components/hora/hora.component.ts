import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hora',
  templateUrl: './hora.component.html',
  styleUrls: ['./hora.component.scss']
})
export class HoraComponent implements OnInit {

  active: Boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  onClick() {
    this.active = !this.active;
  }

}
