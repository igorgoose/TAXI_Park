package epam.training.schepov.park.repository.specification.impl.find;

import com.sun.tools.classfile.Opcode;
import epam.training.schepov.park.factory.RepositoryFactory;
import epam.training.schepov.park.repository.TaxiRepository;
import epam.training.schepov.park.repository.specification.TaxiVehicleSpecification;
import epam.training.schepov.park.entity.TaxiVehicle;

import java.util.Set;
import java.util.TreeSet;

public class TaxiVehicleSpecificationFindById implements TaxiVehicleSpecification {

    private int id;

    public TaxiVehicleSpecificationFindById(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Set<TaxiVehicle> query() {
        TaxiRepository repository = RepositoryFactory.INSTANCE.getTreeSetTaxiVehicleRepository();
        Set<TaxiVehicle> repositorySet = repository.getAll();
        Set<TaxiVehicle> resultSet = new TreeSet<>();
        for (TaxiVehicle taxiVehicle: repositorySet) {
            if(taxiVehicle.getId() == id){
                resultSet.add(taxiVehicle);
            }
        }
        return resultSet;
    }
}
