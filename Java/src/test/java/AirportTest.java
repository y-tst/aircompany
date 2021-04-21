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

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void GetTransportMilitaryPlanes() {
        Airport airport = new Airport(PlanesList.planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            Assert.assertTrue(militaryPlane.getType() == MilitaryType.TRANSPORT);
        }
    }

    @Test
    public void GetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(PlanesList.planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, planeWithMaxPassengerCapacity);
    }

    @Test
    public void SortingPlanesByMaxLoadCapacityIsCorrect() {
        Airport airport = new Airport(PlanesList.planes);
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Assert.assertFalse(planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() > planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity());
        }
    }

    @Test
    public void HasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(PlanesList.planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            Assert.assertFalse(militaryPlane.getType() != MilitaryType.BOMBER);
        }
    }

    @Test
    public void ExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {
        Airport airport = new Airport(PlanesList.planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            Assert.assertFalse(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED);
        }
    }
}
