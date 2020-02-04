package epam.training.schepov.park.repository.impl;

import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TaxiRepositoryHashSet implements TaxiRepository {

    private HashSet<TaxiVehicle> repository;

    public TaxiRepositoryHashSet() {
        repository = new HashSet<>();
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
