import java.io.File;
import java.io.IOException;

import ceilling_fan.CeilingFan;
import ceilling_fan.CeilingFanHighCommand;
import ceilling_fan.CeilingFanOff;
import garage_door.GarageDoor;
import garage_door.GarageDoorStopCommand;
import garage_door.GarageDoorUpCommand;
import hottub.Hottub;
import hottub.HottubCirculateCommand;
import hottub.HottubTemperatureCommand;
import light.Light;
import light.LightOnCommand;
import security_control.SecurityControl;
import security_control.SecurityControlArmCommand;
import sound.Sound;
import sound.SoundDvdCommand;
import sound.SoundOnCommand;
import tv.Tv;
import tv.TvChannelCommand;
import tv.TvOnCommand;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            File file = new File("commands.txt");
            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        RemoteControl remoteControl = new RemoteControl();
        
        CeilingFan ceilingFan = new CeilingFan();
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOff ceilingFanOff = new CeilingFanOff(ceilingFan);
        
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorStopCommand garageDoorStop = new GarageDoorStopCommand(garageDoor);
        
        Hottub hottub = new Hottub();
        HottubCirculateCommand hottubCirculate = new HottubCirculateCommand(hottub);
        HottubTemperatureCommand hottubTemperature = new HottubTemperatureCommand(hottub, 26);

        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);

        SecurityControl securityControl = new SecurityControl();
        SecurityControlArmCommand securityControlArm = new SecurityControlArmCommand(securityControl);

        Sound sound = new Sound();
        SoundOnCommand soundOn = new SoundOnCommand(sound); 
        SoundDvdCommand soundDvd = new SoundDvdCommand(sound);

        Tv tv = new Tv();
        TvOnCommand tvOn = new TvOnCommand(tv);
        TvChannelCommand tvChannel = new TvChannelCommand(tv, 15);

        remoteControl.setCommand(lightOn);

        remoteControl.pressButton(0);

        ceilingFanHigh.store();
        ceilingFanOff.store();
        garageDoorUp.store();
        garageDoorStop.store();
        hottubCirculate.store();
        hottubTemperature.store();
        lightOn.store();
        securityControlArm.store();
        soundOn.store();
        soundDvd.store();
        tvOn.store();
        tvChannel.store();

        System.out.println("\n\n\n-------Deu uma pane eletrica do nada-------\n\n\n");

        remoteControl.loadCommands();
    }
}
