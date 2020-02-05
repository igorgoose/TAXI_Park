package epam.training.schepov.park.factory;

import epam.training.schepov.park.repository.impl.HashSetTaxiVehicleRepository;

public enum RepositoryFactory {

    INSTANCE;

    static class TreeSetTaxiVehicleRepositoryHolder {
        public static final HashSetTaxiVehicleRepository TREE_SET_TAXI_REPOSITORY_INSTANCE = HashSetTaxiVehicleRepository.INSTANCE;
    }

    public HashSetTaxiVehicleRepository getTreeSetTaxiVehicleRepository(){
        return TreeSetTaxiVehicleRepositoryHolder.TREE_SET_TAXI_REPOSITORY_INSTANCE;
    }
}
