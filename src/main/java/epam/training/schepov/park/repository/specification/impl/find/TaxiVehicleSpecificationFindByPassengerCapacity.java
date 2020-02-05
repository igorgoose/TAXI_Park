package epam.training.schepov.park.repository.specification.impl.find;

import epam.training.schepov.park.factory.RepositoryFactory;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.HashSet;
import java.util.Set;

public class TaxiVehicleSpecificationFindByPassengerCapacity implements TaxiVehicleSpecification {

    private int minPassengerCapacity;
    private int maxPassengerCapacity;

    public TaxiVehicleSpecificationFindByPassengerCapacity(int passengerCapacity){
        this.minPassengerCapacity = passengerCapacity;
        this.maxPassengerCapacity = passengerCapacity;
    }

    public TaxiVehicleSpecificationFindByPassengerCapacity(int minPassengerCapacity, int maxPassengerCapacity){
        this.maxPassengerCapacity = maxPassengerCapacity;
        this.minPassengerCapacity = minPassengerCapacity;
    }

    @Override
    public Set<TaxiVehicle> query() {
        TaxiRepository repository = RepositoryFactory.INSTANCE.getTreeSetTaxiVehicleRepository();
        Set<TaxiVehicle> repositorySet = repository.getAll();
        Set<TaxiVehicle> resultSet = new HashSet<>();
        int passengerCapacity;
        for (TaxiVehicle taxiVehicle: repositorySet) {
            passengerCapacity = taxiVehicle.getPassengerCapacity();
            if(passengerCapacity <= maxPassengerCapacity && passengerCapacity >= minPassengerCapacity){
                resultSet.add(taxiVehicle);
            }
        }
        return resultSet;
    }
}
