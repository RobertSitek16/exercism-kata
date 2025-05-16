package remotecontrolcompetition;

class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int distanceUnit;
    private int numberOfVictories;

    public ProductionRemoteControlCar() {
        distanceUnit = 0;
    }

    @Override
    public void drive() {
        distanceUnit += 10;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceUnit;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        return Integer.compare(otherCar.getNumberOfVictories(), getNumberOfVictories());
    }
}
