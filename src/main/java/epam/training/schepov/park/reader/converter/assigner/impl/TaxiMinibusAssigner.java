package epam.training.schepov.park.reader.converter.assigner.impl;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.brand.TaxiBrand;
import epam.training.schepov.park.entity.minibus.RideRegion;
import epam.training.schepov.park.entity.minibus.TaxiMinibus;
import epam.training.schepov.park.exception.converter.ConverterException;
import epam.training.schepov.park.reader.converter.assigner.DependentParameterAssigner;

public enum TaxiMinibusAssigner implements DependentParameterAssigner {

  INSTANCE;

  @Override
  public void assign(TaxiVehicle taxiVehicle, String rideRegionParameter) throws ConverterException {
    if(!(taxiVehicle instanceof TaxiMinibus)){
      throw new ConverterException("taxiVehicle is not of TaxiMinibus type!");
    }
    if(rideRegionParameter == null){
      throw new ConverterException("Null ride region passed!");
    }

    boolean isRideRegion = false;
    for (RideRegion region : RideRegion.values()) {
      if(region.toString().equals(rideRegionParameter.toUpperCase())){
        isRideRegion = true;
        break;
      }
    }

    if(isRideRegion) {
      ((TaxiMinibus)taxiVehicle).setRideRegion(Enum.valueOf(RideRegion.class, rideRegionParameter.toUpperCase()));
    } else {
      throw new ConverterException("Invalid ride region parameter!");
    }
  }

}
