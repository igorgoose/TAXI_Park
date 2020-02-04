package epam.training.schepov.park.service.impl;

import epam.training.schepov.park.exception.service.InvalidVehicleCapacityValueServiceException;
import epam.training.schepov.park.exception.service.NullObjectServiceException;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.impl.TaxiRepositoryHashSet;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.repository.specification.impl.TaxiVehicleSpecificationAny;
import epam.training.schepov.park.service.TaxiService;
import epam.training.schepov.park.service.validator.TaxiValidator;
import epam.training.schepov.park.taxi.TaxiVehicle;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public enum RepositoryTaxiService implements TaxiService {

    INSTANCE;

    private TaxiRepository repository;

    RepositoryTaxiService(){
        repository = new TaxiRepositoryHashSet();
    }


    public void setRepository(TaxiRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException {
        TaxiValidator.validate(taxiVehicle);
        repository.add(taxiVehicle);
    }

    @Override
    public void removeVehicle(TaxiVehicle taxiVehicle) throws InvalidVehicleCapacityValueServiceException, NullObjectServiceException {
        TaxiValidator.validate(taxiVehicle);
        repository.remove(taxiVehicle);
    }

    @Override
    public List<TaxiVehicle> getVehicles(TaxiVehicleSpecification specification) throws NullObjectServiceException {
        if(specification == null){
            //todo log
            throw new NullObjectServiceException("Null specification passed!");
        }
        return repository.get(specification);
    }

    @Override
    public BigDecimal getOverallValue() {
        BigDecimal overallValue = new BigDecimal(0);
        List<TaxiVehicle> vehicleList = repository.get(new TaxiVehicleSpecificationAny());
        for (TaxiVehicle vehicle: vehicleList) {
            overallValue = overallValue.add(vehicle.getPrice());
        }
        return overallValue;
    }

    @Override
    public List<TaxiVehicle> sort(Comparator<TaxiVehicle> comparator) {
        return null;//todo
    }

}
