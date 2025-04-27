package needforspeed;

public class NeedForSpeed {
    private final int speed;
    private final int batteryDrain;
    private int distanceDriven;
    private int batteryCharge = 100;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    public void drive() {
        if (this.batteryCharge >= this.batteryDrain) {
            this.distanceDriven += this.speed;
            this.batteryCharge -= this.batteryDrain;
        }
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public boolean batteryDrained() {
        return this.batteryCharge < this.batteryDrain;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getBatteryDrain() {
        return this.batteryDrain;
    }

}
