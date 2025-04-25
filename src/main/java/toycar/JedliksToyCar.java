package toycar;

public class JedliksToyCar {

    private int batteryCharge;
    private int totalDistance;

    public JedliksToyCar() {
        this.batteryCharge = 100;
        this.totalDistance = 0;
    }

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", totalDistance);
    }

    public String batteryDisplay() {
        return batteryCharge > 0 ? String.format("Battery at %d%%", batteryCharge) : "Battery empty";
    }

    public void drive() {
        if (batteryCharge >= 1) {
            totalDistance += 20;
            batteryCharge -= 1;
        }
    }
}
