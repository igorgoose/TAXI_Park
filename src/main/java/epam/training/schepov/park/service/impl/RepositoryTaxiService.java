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
import epam.training.schepov.park.repository.specification.impl.sort.TaxiVehicleSpecificationSortByID;
import epam.training.schepov.park.repository.specification.impl.sort.TaxiVehicleSpecificationSortByLoadAndPassengers;
import epam.training.schepov.park.repository.specification.impl.sort.TaxiVehicleSpecificationSortByPassengerAndLoad;
import epam.training.schepov.park.service.TaxiService;
import epam.training.schepov.park.validator.TaxiVehicleValidator;
import epam.training.schepov.park.entity.TaxiVehicle;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;


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
    public Set<TaxiVehicle> getVehiclesByLoadCapacity(int minCapacity, int maxCapacity) throws NullObjectServiceException {
        TaxiVehicleSpecification specification = new TaxiVehicleSpecificationFindByLoadCapacity(minCapacity, maxCapacity);
        return repository.query(specification);
    }

    @Override
    public Set<TaxiVehicle> getVehiclesByPassengerCapacity(int minCapacity, int maxCapacity) throws NullObjectServiceException {
        TaxiVehicleSpecification specification = new TaxiVehicleSpecificationFindByPassengerCapacity(minCapacity, maxCapacity);
        return repository.query(specification);
    }

    @Override
    public Set<TaxiVehicle> getAllVehicles() {
        TaxiVehicleSpecification specification = new TaxiVehicleSpecificationFindAll();
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

    @Override
    public Set<TaxiVehicle> sortById() {
        TaxiVehicleSpecification specification = new TaxiVehicleSpecificationSortByID();
        return repository.query(specification);
    }

    @Override
    public Set<TaxiVehicle> sortByLoadAndPassengerCapacity() {
        TaxiVehicleSpecification specification = new TaxiVehicleSpecificationSortByLoadAndPassengers();
        return repository.query(specification);
    }

    @Override
    public Set<TaxiVehicle> sortByPassengerAndLoadCapacity() {
        TaxiVehicleSpecification specification = new TaxiVehicleSpecificationSortByPassengerAndLoad();
        return repository.query(specification);
    }
}
