package epam.training.schepov.park.factory.impl;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.cargo.TaxiCargo;
import epam.training.schepov.park.factory.TaxiVehicleFactory;

public enum TaxiCargoFactory implements TaxiVehicleFactory {
  INSTANCE;

  @Override
  public TaxiVehicle createTaxiVehicle() {
    return new TaxiCargo();
  }
}
