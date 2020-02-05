package epam.training.schepov.park.factory.impl;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.minibus.TaxiMinibus;
import epam.training.schepov.park.factory.TaxiVehicleFactory;

public enum TaxiMinibusFactory implements TaxiVehicleFactory {
  INSTANCE;

  @Override
  public TaxiVehicle createTaxiVehicle() {
    return new TaxiMinibus();
  }
}
