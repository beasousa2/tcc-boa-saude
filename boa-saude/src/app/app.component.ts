import { Component } from '@angular/core';
import { Amplify, Auth, Geo } from 'aws-amplify';
import awsmobile from '../aws-exports';

Amplify.configure({
  Auth: {
    identityPool: 'us-east-2:b494403c-d6a2-4d1e-a456-9bf629fba1a4',
    region: 'us-east-2'
  },
  geo: {
    AmazonLocationService: {
      search_indices: {
        items: "deliveryPlace", // REQUIRED - Amazon Location Service Place Index name
        default: "deliveryPlace", // REQUIRED - Amazon Location Service Place Index name to set as default
      },
      region: 'us-east-2', // REQUIRED - Amazon Location Service Region
    }
  }
});
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

       console.log(Geo.searchByCoordinates([position.coords.longitude, position.coords.longitude]))
      })
    } else {
      alert("Geolocalização não está ativa")
    }
  }
}
