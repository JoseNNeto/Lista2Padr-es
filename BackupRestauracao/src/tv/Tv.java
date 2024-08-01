package tv;
public class Tv {
    public void on() {
        System.out.println("TV Ligada");
    }

    public void off() {
        System.out.println("TV Desligada");
    }

    public void setInputChannel(int canal) {
        System.out.println("Canal selecionado: " + canal);
    }

    public void setVolume(int volume) {
        System.out.println("Volume modificado para " + volume);
    }
}
