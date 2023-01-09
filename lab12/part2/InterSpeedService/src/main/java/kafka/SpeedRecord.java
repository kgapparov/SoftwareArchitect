package kafka;

public class SpeedRecord {
    private  String licencePlate;
    private  int speed;

    public SpeedRecord(String licencePlate, int speed) {
        this.licencePlate=licencePlate;
        this.speed = speed;
    }

    public SpeedRecord() {
    }

    public String getLicencePlate() {
        return licencePlate;
    }
    public int getSpeed() {
        return speed;
    }
}
