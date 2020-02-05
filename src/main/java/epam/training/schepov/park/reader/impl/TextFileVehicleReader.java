package epam.training.schepov.park.reader.impl;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.exception.converter.ConverterException;
import epam.training.schepov.park.exception.reader.ReaderException;
import epam.training.schepov.park.reader.TaxiVehicleReader;
import epam.training.schepov.park.reader.converter.StringToTaxiVehicleConverter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileVehicleReader implements TaxiVehicleReader {
  private File file;

  public TextFileVehicleReader(String filePath) throws ReaderException {
    if(filePath == null){
      throw new ReaderException("Null file path passed!");
    }
    file = new File(getClass().getClassLoader().getResource(filePath).getFile());
  }

  public TextFileVehicleReader(File file) throws ReaderException {
    if (file == null) {
      throw new ReaderException("Null file passed!");
    }
    this.file = file;
  }

  @Override
  public List<TaxiVehicle> read() {
    try(BufferedReader reader = new BufferedReader(new FileReader(file))){
      String vehicleLine;
      StringToTaxiVehicleConverter converter = StringToTaxiVehicleConverter.INSTANCE;
      List<TaxiVehicle> collection = new ArrayList<>();
      while ((vehicleLine = reader.readLine()) != null){
        try {
          collection.add(converter.convert(vehicleLine));
        } catch (ConverterException e) {
          //todo log
        }
      }
      return collection;
    } catch (FileNotFoundException e) {
      throw new ReaderException("File not found!", e);
    } catch (IOException e) {
      throw new ReaderException("Error while reading!", e);
    }
  }
}
