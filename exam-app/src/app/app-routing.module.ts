import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {OwnersComponent} from "./owners/owners.component";
import {VehiclesComponent} from "./vehicles/vehicles.component";
import {RadarsComponent} from "./radars/radars.component";
import {VehiclownerComponent} from "./vehiclowner/vehiclowner.component";
import {InfractionsComponent} from "./infractions/infractions.component";
import {DeleOwnerComponent} from "./dele-owner/dele-owner.component";
import {DeleteVehicleComponent} from "./delete-vehicle/delete-vehicle.component";
import {DeleteradarComponent} from "./deleteradar/deleteradar.component";
import {DeleteinfractionComponent} from "./deleteinfraction/deleteinfraction.component";


const routes: Routes = [
  {
    path:"owners", component : OwnersComponent
  },
  {
    path:"vehicles", component : VehiclesComponent
  },
  {
    path:"radars", component : RadarsComponent
  },
  {
    path:"owners-vehicles/:ownerId", component : VehiclownerComponent
  },
  {
    path:"radars",component :RadarsComponent
  },
  {
    path:"infractions",component :InfractionsComponent
  },
  {
    path:"deleteowner/:ownerId",component :DeleOwnerComponent
  },
  {
    path:"deletevehicle/:vehicleId",component :DeleteVehicleComponent
  },
  {
    path:"deleteradar/:radarId",component :DeleteradarComponent
  },
  {
    path:"deleteinfraction/:infractionId",component :DeleteinfractionComponent
  },



]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
