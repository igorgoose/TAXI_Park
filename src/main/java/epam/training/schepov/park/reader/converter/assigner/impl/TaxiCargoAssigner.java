package epam.training.schepov.park.reader.converter.assigner.impl;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.cargo.BodyType;
import epam.training.schepov.park.entity.cargo.TaxiCargo;
import epam.training.schepov.park.entity.minibus.RideRegion;
import epam.training.schepov.park.entity.minibus.TaxiMinibus;
import epam.training.schepov.park.exception.converter.ConverterException;
import epam.training.schepov.park.reader.converter.assigner.DependentParameterAssigner;

public enum TaxiCargoAssigner implements DependentParameterAssigner {
  INSTANCE;

  @Override
  public void assign(TaxiVehicle taxiVehicle, String bodyTypeParameter) throws ConverterException {
    if(!(taxiVehicle instanceof TaxiCargo)){
      throw new ConverterException("taxiVehicle is not of TaxiCargo type!");
    }
    if(bodyTypeParameter == null){
      throw new ConverterException("Null body type passed!");
    }

    boolean isBodyType = false;
    for (BodyType bodyType : BodyType.values()) {
      if(bodyType.toString().equals(bodyTypeParameter.toUpperCase())){
        isBodyType = true;
        break;
      }
    }

    if(isBodyType) {
      ((TaxiCargo)taxiVehicle).setBodyType(Enum.valueOf(BodyType.class, bodyTypeParameter.toUpperCase()));
    } else {
      throw new ConverterException("Invalid body type parameter!");
    }
  }
}
