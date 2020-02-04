package epam.training.schepov.park.reader.converter;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.auto.TaxiAuto;
import epam.training.schepov.park.exception.converter.ConverterException;

public enum StringToTaxiVehicleConverter {
  INSTANCE;

  private static final String DELIMITER = " ";
  private static final int PARAMETERS_QUANTITY = 5;

  public TaxiVehicle convert(String vehicleLine) throws ConverterException {
    if(vehicleLine == null){
      throw new ConverterException("Null vehicle line passed!");
    }
    String[] params = vehicleLine.split(DELIMITER);
    if(params.length != PARAMETERS_QUANTITY){
      throw new ConverterException("Can't convert the line!");
    }
    return new TaxiAuto();//todo finish method
  }

}
