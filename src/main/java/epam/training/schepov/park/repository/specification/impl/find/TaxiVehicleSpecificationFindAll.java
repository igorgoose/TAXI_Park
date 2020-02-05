package epam.training.schepov.park.repository.specification.impl.find;

import epam.training.schepov.park.factory.RepositoryFactory;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;


import java.util.Set;


public class TaxiVehicleSpecificationFindAll implements TaxiVehicleSpecification {

    @Override
    public Set<TaxiVehicle> query() {
        TaxiRepository repository = RepositoryFactory.INSTANCE.getTreeSetTaxiVehicleRepository();
        return repository.getAll();
    }
}
