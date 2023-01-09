package kafka;

public class SpeedRecord {
    private final String licencePlate;
    private final int speed;
    public SpeedRecord(String licencePlate, int speed) {
        this.licencePlate=licencePlate;
        this.speed = speed;
    }

    public String getLicencePlate() {
        return licencePlate;
    }
    public int getSpeed() {
        return speed;
    }
}
