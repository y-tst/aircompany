import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.List;

public class AirportTest {

    @Test
    public void getTransportMilitaryPlanes() {
        Airport airport = new Airport(PlanesList.planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            Assert.assertTrue(militaryPlane.getType() == MilitaryType.TRANSPORT);
        }
    }

    @Test
    public void getPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(PlanesList.planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, PlanesList.planeWithMaxPassengerCapacity);
    }

    @Test
    public void sortingPlanesByMaxLoadCapacityIsCorrect() {
        Airport airport = new Airport(PlanesList.planes);
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Assert.assertFalse(planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() > planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity());
        }
    }

    @Test
    public void hasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(PlanesList.planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            Assert.assertFalse(militaryPlane.getType() != MilitaryType.BOMBER);
        }
    }

    @Test
    public void experimentalPlanesHasClassificationLevelHigherThanUnclassified() {
        Airport airport = new Airport(PlanesList.planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            Assert.assertFalse(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED);
        }
    }
}
