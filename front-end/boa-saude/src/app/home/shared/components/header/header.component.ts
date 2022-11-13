import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  toggle!: Boolean;
  lat: number = 0;
  lon: number = 0;

  constructor() { }

  ngOnInit(): void {
    this.toggle = true;
  }

  on() {
    this.toggle = true;
    this.getCurrencyLocation();
  }

  off() {
    this.toggle = false;
  }

  getCurrencyLocation() {
    if(navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(position => {
        this.lat = position.coords.latitude;
        this.lon = position.coords.longitude;
        console.log("latitude" + this.lat)
        console.log("longitude" + this.lon)
      })
    } else {
      alert("Geolocalização não está ativa")
    }
  }

}
