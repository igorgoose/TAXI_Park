package epam.training.schepov.park.repository.specification.impl.sort;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.factory.RepositoryFactory;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;


import java.util.Set;
import java.util.TreeSet;

public class TaxiVehicleSpecificationSortByID implements TaxiVehicleSpecification {
    @Override
    public Set<TaxiVehicle> query() {
        TaxiRepository repository = RepositoryFactory.INSTANCE.getTreeSetTaxiVehicleRepository();
        return new TreeSet<>(repository.getAll());
    }
}
