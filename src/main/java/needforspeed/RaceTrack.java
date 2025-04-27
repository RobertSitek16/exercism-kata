package needforspeed;

public class RaceTrack {
    private final int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        int carPossibleDistance = 100 / car.getBatteryDrain() * car.getSpeed();
        return carPossibleDistance >= this.distance;
    }
}
