import { Component, OnInit } from '@angular/core';
import SwiperCore, { Pagination, Navigation } from "swiper";

// install Swiper modules
SwiperCore.use([Pagination, Navigation]);

@Component({
  selector: 'app-prestador',
  templateUrl: './prestador.component.html',
  styleUrls: ['./prestador.component.scss']
})
export class PrestadorComponent implements OnInit {

  active: Boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  onActive() {
    this.active = true;
  }
}
