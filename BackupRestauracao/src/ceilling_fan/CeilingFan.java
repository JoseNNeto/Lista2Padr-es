package ceilling_fan;
public class CeilingFan {
    String speed;

    public CeilingFan() {
        speed = "off";
    }

    public void high() {
        setSpeed("high");
        System.out.println("Velocidade do ventilador mudada para:" + speed);
    }

    public void medium() {
        setSpeed("medium");
        System.out.println("Velocidade do ventilador mudada para:" + speed);
    }

    public void low() {
        setSpeed("low");
        System.out.println("Velocidade do ventilador mudada para:" + speed);
    }

    public void off() {
        setSpeed("off");
        System.out.println("Ventilador desligado");
    }

    public String getSpeed() {
        System.out.println("Velocidade do ventilador:" + speed);
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }    
}
