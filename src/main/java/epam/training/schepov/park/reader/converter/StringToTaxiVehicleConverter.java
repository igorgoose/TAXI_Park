package epam.training.schepov.park.reader.converter;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.entity.brand.TaxiBrand;
import epam.training.schepov.park.exception.converter.ConverterException;
import epam.training.schepov.park.exception.validator.InvalidVehicleCapacityValueValidatorException;
import epam.training.schepov.park.exception.validator.NullObjectTaxiVehicleValidatorException;
import epam.training.schepov.park.factory.TaxiVehicleFactory;
import epam.training.schepov.park.factory.impl.TaxiAutoFactory;
import epam.training.schepov.park.factory.impl.TaxiCargoFactory;
import epam.training.schepov.park.factory.impl.TaxiMinibusFactory;
import epam.training.schepov.park.reader.converter.assigner.DependentParameterAssigner;
import epam.training.schepov.park.reader.converter.assigner.impl.TaxiAutoAssigner;
import epam.training.schepov.park.reader.converter.assigner.impl.TaxiCargoAssigner;
import epam.training.schepov.park.reader.converter.assigner.impl.TaxiMinibusAssigner;
import epam.training.schepov.park.validator.TaxiVehicleValidator;

import java.math.BigDecimal;

public enum StringToTaxiVehicleConverter {
  INSTANCE;

  private static final String DELIMITER = " ";
  private static final int PARAMETERS_QUANTITY = 6;
  private static final int CLASS_INDEX = 0;
  private static final int PRICE_INDEX = 1;
  private static final int LOAD_CAPACITY_INDEX = 2;
  private static final int PASSENGER_CAPACITY_INDEX = 3;
  private static final int BRAND_INDEX = 4;
  private static final int CLASS_DEPENDENT_INDEX = 5;
  private static final String TAXI_AUTO_CLASS_PARAMETER = "AUTO";
  private static final String TAXI_CARGO_CLASS_PARAMETER = "CARGO";
  private static final String TAXI_MINIBUS_CLASS_PARAMETER = "MINIBUS";
  private TaxiVehicleFactory taxiVehicleFactory;
  private DependentParameterAssigner assigner;

  public TaxiVehicle convert(String vehicleLine) throws ConverterException, InvalidVehicleCapacityValueValidatorException, NullObjectTaxiVehicleValidatorException {
    if (vehicleLine == null) {
      throw new ConverterException("Null vehicle line passed!");
    }
    String[] parameters = vehicleLine.split(DELIMITER);
    if (parameters.length != PARAMETERS_QUANTITY) {
      throw new ConverterException("Can't convert the line!");
    }
    chooseFactoryAndAssigner(parameters[CLASS_INDEX]);

    TaxiVehicle taxiVehicle = taxiVehicleFactory.createTaxiVehicle();
    assignPrice(taxiVehicle, parameters[PRICE_INDEX]);
    assignLoadCapacity(taxiVehicle, parameters[LOAD_CAPACITY_INDEX]);
    assignPassengerCapacity(taxiVehicle, parameters[PASSENGER_CAPACITY_INDEX]);
    assignBrand(taxiVehicle, parameters[BRAND_INDEX]);
    assigner.assign(taxiVehicle, parameters[CLASS_DEPENDENT_INDEX]);
    TaxiVehicleValidator.validate(taxiVehicle);
    return taxiVehicle;
  }

  private void chooseFactoryAndAssigner(String factoryParameter) throws ConverterException {
    if (factoryParameter == null) {
      throw new ConverterException("Null class parameter!");
    }
    factoryParameter = factoryParameter.toUpperCase();
    switch (factoryParameter) {
      case TAXI_AUTO_CLASS_PARAMETER:
        taxiVehicleFactory = TaxiAutoFactory.INSTANCE;
        assigner = TaxiAutoAssigner.INSTANCE;
        break;
      case TAXI_CARGO_CLASS_PARAMETER:
        taxiVehicleFactory = TaxiCargoFactory.INSTANCE;
        assigner = TaxiCargoAssigner.INSTANCE;
        break;
      case TAXI_MINIBUS_CLASS_PARAMETER:
        taxiVehicleFactory = TaxiMinibusFactory.INSTANCE;
        assigner = TaxiMinibusAssigner.INSTANCE;
        break;
      default:
        throw new ConverterException("Invalid class parameter!");
    }
  }

  private void assignPrice(TaxiVehicle taxiVehicle, String priceParameter)
      throws ConverterException {
    if (priceParameter == null) {
      throw new ConverterException("Null price parameter!");
    }
    try {
      BigDecimal price = new BigDecimal(priceParameter);
      taxiVehicle.setPrice(price);
    } catch (NumberFormatException e) {
      throw new ConverterException("Invalid price parameter!", e);
    }
  }

  private void assignLoadCapacity(TaxiVehicle taxiVehicle, String loadCapacityParameter)
      throws ConverterException {
    if (loadCapacityParameter == null) {
      throw new ConverterException("Null load capacity parameter!");
    }
    try {
      taxiVehicle.setLoadCapacity(Integer.parseInt(loadCapacityParameter));
    } catch (NumberFormatException e) {
      throw new ConverterException("Invalid load capacity parameter!", e);
    }
  }

  private void assignPassengerCapacity(TaxiVehicle taxiVehicle, String passengerCapacityParameter)
      throws ConverterException {
    if (passengerCapacityParameter == null) {
      throw new ConverterException("Null passenger capacity parameter!");
    }
    try {
      taxiVehicle.setPassengerCapacity(Integer.parseInt(passengerCapacityParameter));
    } catch (NumberFormatException e) {
      throw new ConverterException("Invalid passenger capacity parameter!", e);
    }
  }

  private void assignBrand(TaxiVehicle taxiVehicle, String brandParameter)
      throws ConverterException {
    if (brandParameter == null) {
      throw new ConverterException("Null brand parameter");
    }

    boolean isBrand = false;
    for (TaxiBrand brand : TaxiBrand.values()) {
      if(brand.toString().equals(brandParameter.toUpperCase())){
        isBrand = true;
        break;
      }
    }

    if(isBrand) {
      taxiVehicle.setBrand(Enum.valueOf(TaxiBrand.class, brandParameter.toUpperCase()));
    } else {
      throw new ConverterException("Invalid brand parameter!");
    }
  }


}
