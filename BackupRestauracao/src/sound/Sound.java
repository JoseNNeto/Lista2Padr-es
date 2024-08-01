package sound;
public class Sound {
    public void on() {
        System.out.println("Sound Ligado");
    }

    public void off() {
        System.out.println("Sound Desligado");
    }

    public void setCd() {
        System.out.println("CD Colocado");
    }

    public void setDvd() {
        System.out.println("DVD Colocado");
    }

    public void setRadio() {
        System.out.println("Radio Selecionado");
    }

    public void setVolume(int volume) {
        System.out.println("Volume mudado para " + volume);
    }
}
