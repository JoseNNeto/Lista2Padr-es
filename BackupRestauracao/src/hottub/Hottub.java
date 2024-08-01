package hottub;
public class Hottub {
    int temperature;

    public Hottub() {
        temperature = 25;
    }

    public void circulateOn() {
        System.out.println("Jacuzzi está circulando");
    }

    public void circulateOff() {
        System.out.println("Circulação da Jacuzzi desligada");
    }

    public void jetsOn() {
        System.out.println("Jatos da Jacuzzi ligados");
    }

    public void jetsOff() {
        System.out.println("Jatos da Jacuzzi desligados");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperatua da Jacuzzi mudada para " + temperature + "°C");
    }

    public int getTemperature() {
        System.out.println("Temperatura da Jacuzzi: " + temperature + "°C");
        return temperature;
    }
}
