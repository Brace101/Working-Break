package bike;

public class Bike {
    private boolean engineOn;
    private int gear;
    private int speed;

    public Bike(){
        this.engineOn = false;
        this.gear = 1;
        this.speed = 0;
    }
    public boolean turnOn() {
        return this.engineOn = true;
    }

    public boolean turnOff() {
        return this.engineOn = false;
    }

    private void updateGear(){
        if (speed <= 20 ){
            this.gear = 1;
        } else if (speed <= 30) {
            this.gear = 2;
        } else if (speed <=40) {
            this.gear = 3;
        } else {
            this.gear = 4;
        }

    }

    public void setSpeed(int speed) {
        this.speed = speed;
        updateGear();
    }

    public int getGear(){
        return gear;
    }

    public int getSpeed(){
        return speed;
    }

    public void accelerator() {
        if(engineOn){
            speed+=gear;
            updateGear();
        }

    }

    public void deaccelerate() {
        if (turnOn()) {
            speed -= gear;
            if (speed < 0) {
                speed = 0;
            }
            updateGear();
        }

    }

}