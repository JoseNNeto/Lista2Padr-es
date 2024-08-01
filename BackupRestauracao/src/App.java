import light.Light;
import light.LightOnCommand;

public class App {
    public static void main(String[] args) throws Exception {
        RemoteControl remoteControl = new RemoteControl();

        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        

        remoteControl.setCommand(lightOn);

        remoteControl.pressButton(0);

        lightOn.store();

        System.out.println("Deu ruim");

        remoteControl.loadCommands();
    }
}
