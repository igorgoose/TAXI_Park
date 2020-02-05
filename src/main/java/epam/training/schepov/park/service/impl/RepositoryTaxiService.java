package epam.training.schepov.park.service.impl;

import epam.training.schepov.park.exception.service.InvalidVehicleCapacityValueServiceException;
import epam.training.schepov.park.exception.service.NullObjectServiceException;
import epam.training.schepov.park.exception.validator.InvalidVehicleCapacityValueValidatorException;
import epam.training.schepov.park.exception.validator.NullObjectTaxiVehicleValidatorException;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.impl.TaxiRepositoryArrayList;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.repository.specification.impl.TaxiVehicleSpecificationAny;
import epam.training.schepov.park.service.TaxiService;
import epam.training.schepov.park.validator.TaxiVehicleValidator;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;


public enum RepositoryTaxiService implements TaxiService {

    INSTANCE;

    private TaxiRepository repository;

    RepositoryTaxiService(){
        repository = new TaxiRepositoryArrayList();
    }


    public void setRepository(TaxiRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException {
        try {
            TaxiVehicleValidator.validate(taxiVehicle);
        } catch (NullObjectTaxiVehicleValidatorException e) {
            throw new NullObjectServiceException(e);
        } catch (InvalidVehicleCapacityValueValidatorException e) {
            throw new InvalidVehicleCapacityValueServiceException(e);
        }
        repository.add(taxiVehicle);
    }

    @Override
    public void removeVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException {
        try {
            TaxiVehicleValidator.validate(taxiVehicle);
        } catch (NullObjectTaxiVehicleValidatorException e) {
            throw new NullObjectServiceException(e);
        } catch (InvalidVehicleCapacityValueValidatorException e) {
            throw new InvalidVehicleCapacityValueServiceException(e);
        }
        repository.remove(taxiVehicle);
    }

    @Override
    public Collection<TaxiVehicle> getVehicles(TaxiVehicleSpecification specification) throws NullObjectServiceException {
        if(specification == null){
            //todo log
            throw new NullObjectServiceException("Null specification passed!");
        }
        return repository.get(specification);
    }

    @Override
    public BigDecimal getOverallValue() {
        BigDecimal overallValue = new BigDecimal(0);
        Collection<TaxiVehicle> vehicleList = repository.get(new TaxiVehicleSpecificationAny());
        for (TaxiVehicle vehicle: vehicleList) {
            overallValue = overallValue.add(vehicle.getPrice());
        }
        return overallValue;
    }

    @Override
    public void sort(Comparator<TaxiVehicle> comparator) {
        if(comparator == null){

        }
    }

}
