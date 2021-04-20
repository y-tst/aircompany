import java.util.logging.Logger;

public class Runner {

    public static void main(String[] args) {

        final Logger logger = Logger.getGlobal();
        Airport airport = new Airport(PlanesList.planes);
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlane());
        logger.info("Military airport sorted by max distance: " + militaryAirport
                .sortByMaxDistance()
                .toString());
        logger.info("Passenger airport sorted by max speed: " + passengerAirport
                .sortByMaxSpeed()
                .toString());

        logger.info("Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
