package epam.training.schepov.park.reader.converter.assigner.impl;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.auto.LuxuryClass;
import epam.training.schepov.park.entity.auto.TaxiAuto;
import epam.training.schepov.park.entity.cargo.BodyType;
import epam.training.schepov.park.entity.cargo.TaxiCargo;
import epam.training.schepov.park.exception.converter.ConverterException;
import epam.training.schepov.park.reader.converter.assigner.DependentParameterAssigner;

public enum TaxiAutoAssigner implements DependentParameterAssigner {
  INSTANCE;

  @Override
  public void assign(TaxiVehicle taxiVehicle, String luxuryClassParameter)
      throws ConverterException {
    if(!(taxiVehicle instanceof TaxiAuto)){
      throw new ConverterException("taxiVehicle is not of TaxiAuto type!");
    }
    if(luxuryClassParameter == null){
      throw new ConverterException("Null luxury class passed!");
    }

    boolean isLuxuryClass = false;
    for (LuxuryClass luxuryClass : LuxuryClass.values()) {
      if(luxuryClass.toString().equals(luxuryClassParameter.toUpperCase())){
        isLuxuryClass = true;
        break;
      }
    }

    if(isLuxuryClass) {
      ((TaxiAuto)taxiVehicle).setLuxuryClass(Enum.valueOf(LuxuryClass.class, luxuryClassParameter.toUpperCase()));
    } else {
      throw new ConverterException("Invalid body type parameter!");
    }
  }
}
