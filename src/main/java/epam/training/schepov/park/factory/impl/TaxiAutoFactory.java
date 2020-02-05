package epam.training.schepov.park.factory.impl;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.auto.TaxiAuto;
import epam.training.schepov.park.factory.TaxiVehicleFactory;

public enum TaxiAutoFactory implements TaxiVehicleFactory {
  INSTANCE;

  @Override
  public TaxiVehicle createTaxiVehicle() {
    return new TaxiAuto();
  }
}
