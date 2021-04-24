package planes;

import java.util.Objects;

public class PassengerPlane extends Plane {

    private int passengersCapacity;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",", passengersCapacity=" + passengersCapacity + '}');
    }

    @Override
    public boolean equals(Object isPassengerPlane) {
        if (this == isPassengerPlane) {
            return true;
        }
        if (!(isPassengerPlane instanceof PassengerPlane)) {
            return false;
        }
        if (!super.equals(isPassengerPlane)) {
            return false;
        }
        PassengerPlane plane = (PassengerPlane) isPassengerPlane;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
