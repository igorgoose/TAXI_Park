package epam.training.schepov.park.reader;

import epam.training.schepov.park.entity.TaxiVehicle;
import java.util.Collection;

public interface TaxiVehicleReader {
    Collection<TaxiVehicle> read();
}
