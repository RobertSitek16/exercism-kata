package carsassemble;

public class CarsAssemble {

    private static final int NUMBER_OF_CARS_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        double successRate = 1.00;
        double productionRate = speed * NUMBER_OF_CARS_PER_HOUR;
        if (speed > 9) {
            successRate *= 0.77;
            productionRate *= successRate;
        } else if (speed > 8) {
            successRate *= 0.8;
            productionRate *= successRate;
        } else if (speed > 4) {
            successRate *= 0.9;
            productionRate *= successRate;
        }
        return productionRate;
    }

    public int workingItemsPerMinute(int speed) {
        double ratePerHour = productionRatePerHour(speed);
        return (int) (ratePerHour / 60);
    }
}
