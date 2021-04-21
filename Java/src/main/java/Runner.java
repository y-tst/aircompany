import java.util.logging.Logger;

public class Runner {

    public static void main(String[] args) {

        final Logger logger = Logger.getGlobal();
        Airport airport = new Airport(PlanesList.planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlane());
        logger.info(String.format("Military airport sorted by max distance: %s",militaryAirport.sortByMaxDistance().toString()));
        logger.info(String.format("Passenger airport sorted by max speed: %s" ,passengerAirport.sortByMaxSpeed().toString()));
        logger.info(String.format("Plane with max passenger capacity: %s" ,passengerAirport.getPassengerPlaneWithMaxPassengersCapacity()));
    }
}
