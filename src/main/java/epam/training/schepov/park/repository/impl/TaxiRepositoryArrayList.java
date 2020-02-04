package epam.training.schepov.park.repository.impl;

import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.taxi.TaxiVehicle;

import java.util.ArrayList;
import java.util.List;

public class TaxiRepositoryArrayList implements TaxiRepository {

    private ArrayList<TaxiVehicle> repository;

    public TaxiRepositoryArrayList() {
        repository = new ArrayList<TaxiVehicle>();
    }

    @Override
    public void add(TaxiVehicle taxiVehicle) {//todo validation
        repository.add(taxiVehicle);
    }

    @Override
    public void remove(TaxiVehicle taxiVehicle) {
        repository.remove(taxiVehicle);
    }

    @Override
    public List<TaxiVehicle> get(TaxiVehicleSpecification specification) {
        ArrayList<TaxiVehicle> specifiedList = new ArrayList<>();
        for (TaxiVehicle taxiVehicle : repository) {
            if(specification.matches(taxiVehicle)){
                specifiedList.add(taxiVehicle);
            }
        }
        return specifiedList;
    }
}
