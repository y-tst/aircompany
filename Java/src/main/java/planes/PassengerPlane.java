package planes;

import java.util.Objects;

public class PassengerPlane extends Plane{

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
        return super.toString().replace("}",
                ", passengersCapacity=" + passengersCapacity +
                '}');
    }

    @Override
    public boolean equals(Object isPassangerPlane) {
        if (this == isPassangerPlane) return true;
        if (!(isPassangerPlane instanceof PassengerPlane)) return false;
        if (!super.equals(isPassangerPlane)) return false;
        PassengerPlane plane = (PassengerPlane) isPassangerPlane;
        return passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passengersCapacity);
    }
}
