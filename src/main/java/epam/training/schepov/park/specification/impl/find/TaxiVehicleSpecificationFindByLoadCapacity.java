package epam.training.schepov.park.specification.impl.find;

import epam.training.schepov.park.factory.RepositoryFactory;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.HashSet;
import java.util.Set;

public class TaxiVehicleSpecificationFindByLoadCapacity implements TaxiVehicleSpecification {

    private int minLoadCapacity;
    private int maxLoadCapacity;

    public TaxiVehicleSpecificationFindByLoadCapacity(int loadCapacity){
        this.minLoadCapacity = loadCapacity;
        this.maxLoadCapacity = loadCapacity;
    }

    public TaxiVehicleSpecificationFindByLoadCapacity(int minLoadCapacity, int maxLoadCapacity){
        this.maxLoadCapacity = maxLoadCapacity;
        this.minLoadCapacity = minLoadCapacity;
    }

    @Override
    public Set<TaxiVehicle> query() {
        TaxiRepository repository = RepositoryFactory.INSTANCE.getTreeSetTaxiVehicleRepository();
        Set<TaxiVehicle> repositorySet = repository.getAll();
        Set<TaxiVehicle> resultSet = new HashSet<>();
        int loadCapacity;
        for (TaxiVehicle taxiVehicle: repositorySet) {
            loadCapacity = taxiVehicle.getLoadCapacity();
            if(loadCapacity <= maxLoadCapacity && loadCapacity >= minLoadCapacity){
                resultSet.add(taxiVehicle);
            }
        }
        return resultSet;
    }
}
