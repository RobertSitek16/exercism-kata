package remotecontrolcompetition;

public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceUnit;

    public ExperimentalRemoteControlCar() {
        distanceUnit = 0;
    }

    @Override
    public void drive() {
        distanceUnit += 20;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceUnit;
    }
}
