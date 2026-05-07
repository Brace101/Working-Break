public class AC {
    private boolean powerOn;
    private int temperature;

    public boolean isOff()  {

        return !powerOn;
    }

    public void turnOnAC() {

        powerOn = true;
        temperature = 24;

    }

    public void turnOffAC() {
        powerOn = false;
    }

    public void increaseTemperature() {
        if (!powerOn) return;

        if (temperature == 30) return;

        temperature += 1;

    }

    public int getTemperature() {
        if (powerOn)
            return temperature;

        return -1;
    }

    public void decreaseTemperature() {
        if (!powerOn) return;
        if  (temperature == 16) return;
        temperature -= 1;
    }
}