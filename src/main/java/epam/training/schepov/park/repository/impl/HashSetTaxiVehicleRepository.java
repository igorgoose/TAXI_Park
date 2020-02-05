package epam.training.schepov.park.repository.impl;

import epam.training.schepov.park.exception.repository.RepositoryException;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public enum HashSetTaxiVehicleRepository implements TaxiRepository {

    INSTANCE;

    private final static Logger LOGGER = Logger.getLogger(HashSetTaxiVehicleRepository.class);

    private HashSet<TaxiVehicle> repository;

    HashSetTaxiVehicleRepository() {
        repository = new HashSet<>();
    }

    @Override
    public void add(TaxiVehicle taxiVehicle) {
        if (taxiVehicle == null) {
            LOGGER.info("add : Null comparator passed");
            throw new RepositoryException("Null taxiVehicle passed!");
        }
        repository.add(taxiVehicle);
    }

    @Override
    public void remove(TaxiVehicle taxiVehicle) {
        if (taxiVehicle == null) {
            LOGGER.info("remove : Null comparator passed");
            throw new RepositoryException("Null taxiVehicle passed!");
        }
        repository.remove(taxiVehicle);
    }

    @Override
    public void update(TaxiVehicle taxiVehicle) {

    }

    @Override
    public Set<TaxiVehicle> getAll() {
        return new TreeSet<>(repository);
    }


    @Override
    public Set<TaxiVehicle> query(TaxiVehicleSpecification specification) {
        if (specification == null) {
            LOGGER.info("query : Null comparator passed");
            throw new RepositoryException("Null specification passed!");
        }
//        TreeSet<TaxiVehicle> specifiedList = new TreeSet<>();
//        for (TaxiVehicle taxiVehicle : repository) {
//            if (specification.query(taxiVehicle)) {
//                specifiedList.add(taxiVehicle);
//            }
//        }

        return specification.query();
    }


//    @Override
//    public void sort(Comparator<TaxiVehicle> comparator) {
//        if (comparator == null) {
//            LOGGER.info("sort : Null comparator passed");
//            throw new RepositoryException("Null comparator passed!");
//        }
//        repository.sort(comparator);
//    }

}
