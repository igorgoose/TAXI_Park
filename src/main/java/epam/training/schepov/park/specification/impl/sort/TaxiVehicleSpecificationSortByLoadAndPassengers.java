package epam.training.schepov.park.specification.impl.sort;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.factory.RepositoryFactory;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.specification.impl.sort.comparator.TaxiVehicleComparatorByLoadAndPassenger;

import java.util.Set;
import java.util.TreeSet;

public class TaxiVehicleSpecificationSortByLoadAndPassengers implements TaxiVehicleSpecification {
    @Override
    public Set<TaxiVehicle> query() {
        TaxiRepository repository = RepositoryFactory.INSTANCE.getTreeSetTaxiVehicleRepository();
        TreeSet<TaxiVehicle> resultSet = new TreeSet<>(new TaxiVehicleComparatorByLoadAndPassenger());
        resultSet.addAll(repository.getAll());
        return resultSet;
    }
}
