package epam.training.schepov.park.reader.converter.assigner;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.exception.converter.ConverterException;

public interface DependentParameterAssigner {
  void assign(TaxiVehicle taxiVehicle, String dependentParameter) throws ConverterException;
}
