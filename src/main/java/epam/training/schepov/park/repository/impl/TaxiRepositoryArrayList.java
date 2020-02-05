package epam.training.schepov.park.repository.impl;

import epam.training.schepov.park.exception.repository.RepositoryException;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.ArrayList;
import java.util.Comparator;

public class TaxiRepositoryArrayList implements TaxiRepository {

  private ArrayList<TaxiVehicle> repository;

  public TaxiRepositoryArrayList() {
    repository = new ArrayList<>();
  }

  @Override
  public void add(TaxiVehicle taxiVehicle) {
    if (taxiVehicle == null) {
      throw new RepositoryException("Null taxiVehicle passed!");
    }
    repository.add(taxiVehicle);
  }

  @Override
  public void remove(TaxiVehicle taxiVehicle) {
    if (taxiVehicle == null) {
      throw new RepositoryException("Null taxiVehicle passed!");
    }
    repository.remove(taxiVehicle);
  }

  @Override
  public ArrayList<TaxiVehicle> get(TaxiVehicleSpecification specification) {
    if (specification == null) {
      throw new RepositoryException("Null specification passed!");
    }
    ArrayList<TaxiVehicle> specifiedList = new ArrayList<TaxiVehicle>();
    for (TaxiVehicle taxiVehicle : repository) {
      if (specification.matches(taxiVehicle)) {
        specifiedList.add(taxiVehicle);
      }
    }
    return specifiedList;
  }

  @Override
  public ArrayList<TaxiVehicle> getAll() {
    return new ArrayList<>(repository);
  }

  @Override
  public void sort(Comparator<TaxiVehicle> comparator) {
    if(comparator == null){
        throw new RepositoryException("Null comparator passed!");
    }

  }

}
