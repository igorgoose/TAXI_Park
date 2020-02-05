package epam.training.schepov.park.service.impl;

import epam.training.schepov.park.exception.service.InvalidVehicleCapacityValueServiceException;
import epam.training.schepov.park.exception.service.NullObjectServiceException;
import epam.training.schepov.park.exception.validator.InvalidVehicleCapacityValueValidatorException;
import epam.training.schepov.park.exception.validator.NullObjectTaxiVehicleValidatorException;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.impl.HashSetTaxiVehicleRepository;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.repository.specification.impl.find.TaxiVehicleSpecificationFindAll;
import epam.training.schepov.park.repository.specification.impl.find.TaxiVehicleSpecificationFindByLoadCapacity;
import epam.training.schepov.park.repository.specification.impl.find.TaxiVehicleSpecificationFindByPassengerCapacity;
import epam.training.schepov.park.service.TaxiService;
import epam.training.schepov.park.validator.TaxiVehicleValidator;
import epam.training.schepov.park.entity.TaxiVehicle;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;


public enum RepositoryTaxiService implements TaxiService {

    INSTANCE;

    private final static Logger LOGGER = Logger.getLogger(RepositoryTaxiService.class);

    private TaxiRepository repository;

    RepositoryTaxiService() {
        repository = HashSetTaxiVehicleRepository.INSTANCE;
    }


    public void setRepository(TaxiRepository repository) {
        this.repository = repository;
    }

    //todo add update()

    @Override
    public void addVehicle(TaxiVehicle taxiVehicle)
            throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException {
        try {
            TaxiVehicleValidator.validate(taxiVehicle);
        } catch (NullObjectTaxiVehicleValidatorException e) {
          LOGGER.warn("Null taxi vehicle passed!", e);
            throw new NullObjectServiceException(e);
        } catch (InvalidVehicleCapacityValueValidatorException e) {
          LOGGER.warn("Invalid  passed!", e);
            throw new InvalidVehicleCapacityValueServiceException(e);
        }
        repository.add(taxiVehicle);
    }

    @Override
    public void removeVehicle(TaxiVehicle taxiVehicle)
            throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException {
        try {
            TaxiVehicleValidator.validate(taxiVehicle);
        } catch (NullObjectTaxiVehicleValidatorException e) {
            LOGGER.warn("Null taxi vehicle passed!", e);
            throw new NullObjectServiceException(e);
        } catch (InvalidVehicleCapacityValueValidatorException e) {
            LOGGER.warn("Invalid  passed!", e);
            throw new InvalidVehicleCapacityValueServiceException(e);
        }
        repository.remove(taxiVehicle);
    }

    @Override
    public List<TaxiVehicle> getVehiclesByLoadCapacity(int minCapacity, int maxCapacity) throws NullObjectServiceException {
        return getVehicles(new TaxiVehicleSpecificationFindByLoadCapacity(minCapacity, maxCapacity));
    }

    @Override
    public List<TaxiVehicle> getVehiclesByPassengerCapacity(int minCapacity, int maxCapacity) throws NullObjectServiceException {
        return getVehicles(new TaxiVehicleSpecificationFindByPassengerCapacity(minCapacity, maxCapacity));
    }

    @Override
    public List<TaxiVehicle> getAllVehicles() {
        return repository.query(new TaxiVehicleSpecificationFindAll());
    }

    private List<TaxiVehicle> getVehicles(TaxiVehicleSpecification specification)
            throws NullObjectServiceException {
        if (specification == null) {
            LOGGER.warn("Null specification passed!");
            throw new NullObjectServiceException("Null specification passed!");
        }
        return repository.query(specification);
    }

    @Override
    public BigDecimal getOverallValue() {
        BigDecimal overallValue = new BigDecimal(0);
        Collection<TaxiVehicle> vehicleList = repository.query(new TaxiVehicleSpecificationFindAll());
        for (TaxiVehicle vehicle : vehicleList) {
            overallValue = overallValue.add(vehicle.getPrice());
        }
        return overallValue;
    }


    private void sort(Comparator<TaxiVehicle> comparator) throws NullObjectServiceException {
        if (comparator == null) {
            LOGGER.warn("Null comparator passed!");
            throw new NullObjectServiceException("Null comparator passed!");
        }
        repository.sort(comparator);
    }

    @Override
    public void sortById() throws NullObjectServiceException {
        sort(Comparator.comparingInt(TaxiVehicle::getId));
    }

    @Override
    public void sortByLoadAndPassengerCapacityGreater() throws NullObjectServiceException {
        sort((o1, o2) -> {//todo remove lambda
            if (o1.getLoadCapacity() != o2.getLoadCapacity()) {
                return o2.getLoadCapacity() - o1.getLoadCapacity();
            }
            return o2.getPassengerCapacity() - o1.getPassengerCapacity();
        });
    }

    @Override
    public void sortByLoadAndPassengerCapacityLess() throws NullObjectServiceException {
        sort((o2, o1) -> {//todo remove lambda
            if (o1.getLoadCapacity() != o2.getLoadCapacity()) {
                return o2.getLoadCapacity() - o1.getLoadCapacity();
            }
            return o2.getPassengerCapacity() - o1.getPassengerCapacity();
        });
    }

}
