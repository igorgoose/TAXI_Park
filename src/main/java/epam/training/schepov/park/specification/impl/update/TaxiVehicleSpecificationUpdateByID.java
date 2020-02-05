package epam.training.schepov.park.specification.impl.update;

import epam.training.schepov.park.entity.TaxiVehicle;
import epam.training.schepov.park.factory.RepositoryFactory;
import epam.training.schepov.park.reader.impl.TextFileVehicleReader;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.specification.TaxiVehicleSpecification;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class TaxiVehicleSpecificationUpdateByID implements TaxiVehicleSpecification {
    TaxiVehicle newTaxiVehicle;

    public TaxiVehicleSpecificationUpdateByID(TaxiVehicle newTaxiVehicle){
        this.newTaxiVehicle = newTaxiVehicle;
    }

    @Override
    public Set<TaxiVehicle> query() {
        TaxiRepository repository = RepositoryFactory.INSTANCE.getTreeSetTaxiVehicleRepository();
        Set<TaxiVehicle> resultSet = repository.getAll();
        Iterator<TaxiVehicle> iterator = resultSet.iterator();
        while(iterator.hasNext()){
            TaxiVehicle currentVehicle = iterator.next();
            if(currentVehicle.getId() == newTaxiVehicle.getId()){
                iterator.remove();
            }
        }
        resultSet.add(newTaxiVehicle);
        return new TreeSet<>(resultSet);
    }
}
