import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'BoaSaude';
  lat: number = 0;
  lon: number = 0;

  ngOnInit() {
    this.getCurrencyLocation();
  }

  getCurrencyLocation() {
    if(navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(position => {
        this.lat = position.coords.latitude;
        this.lon = position.coords.longitude;
        console.log("lat: " + this.lat + " lon: " + this.lon)
      })
    } else {
      alert("Geolocalização não está ativa")
    }
  }
}
