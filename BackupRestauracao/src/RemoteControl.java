import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ceilling_fan.*;
import command.Command;
import garage_door.*;
import hottub.*;
import light.*;
import security_control.*;
import sound.*;
import tv.Tv;
import tv.TvChannelCommand;
import tv.TvOffCommand;
import tv.TvOnCommand;
import tv.TvVolumeCommand;

public class RemoteControl {
    List<Command> commands = new ArrayList<>();
    Map<String, Command> commandMap = new HashMap<>();

    public RemoteControl() {
        CeilingFan ceilingFan = new CeilingFan();
        commandMap.put("CeilingFanHigh", new CeilingFanHighCommand(ceilingFan));
        commandMap.put("CeilingFanMedium", new CeilingFanMediumCommand(ceilingFan));
        commandMap.put("CeilingFanLow", new CeilingFanLowCommand(ceilingFan));
        commandMap.put("CeilingFanOff", new CeilingFanOff(ceilingFan));

        GarageDoor garageDoor = new GarageDoor();
        commandMap.put("GarageDoorUp", new GarageDoorUpCommand(garageDoor));
        commandMap.put("GarageDoorDown", new GarageDoorDownCommand(garageDoor));
        commandMap.put("GarageDoorStop", new GarageDoorStopCommand(garageDoor));

        Hottub hottub = new Hottub();
        commandMap.put("HottubCirculate", new HottubCirculateCommand(hottub));
        commandMap.put("HottubJetsOn", new HottubJetsOnCommand(hottub));
        commandMap.put("HottubJetsOff", new HottubJetsOffCommand(hottub));
        commandMap.put("HottubTemperature", new HottubTemperatureCommand(hottub, 26));

        Light light = new Light();
        commandMap.put("LightOn", new LightOnCommand(light));
        commandMap.put("LightOff", new LightOffCommand(light));

        SecurityControl securityControl = new SecurityControl();
        commandMap.put("SecurityControlArm", new SecurityControlArmCommand(securityControl));
        commandMap.put("SecurityControlDisarm", new SecurityControlDisarmCommand(securityControl));
        
        Sound sound = new Sound();
        commandMap.put("SoundOn", new SoundOnCommand(sound));
        commandMap.put("SoundOff", new SoundOffCommand(sound));
        commandMap.put("SoundCd", new SoundCdCommand(sound));
        commandMap.put("SoundDvd", new SoundDvdCommand(sound));
        commandMap.put("SoundRadio", new SoundRadioCommand(sound));
        commandMap.put("SoundVolume", new SoundVolumeCommand(sound, 10));

        Tv tv = new Tv();
        commandMap.put("TvOn", new TvOnCommand(tv));
        commandMap.put("TvOff", new TvOffCommand(tv));
        commandMap.put("TvChannel", new TvChannelCommand(tv, 13));
        commandMap.put("TvVolume", new TvVolumeCommand(tv, 0));
    }

    public void setCommand(Command command) {
        commands.add(command);
    }

    public void pressButton(int index) {
        if (index < commands.size()) {
            commands.get(index).execute();
        } else {
            System.out.println("No command assigned to button " + index);
        }
    }

    public void storeCommands() {
        for (Command command : commands) {
            command.store();
        }
    }

    public void loadCommands() {
        try (BufferedReader reader = new BufferedReader(new FileReader("commands.txt"))) {
            String commandName;
            while ((commandName = reader.readLine()) != null) {
                Command command = commandMap.get(commandName);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Unknown command: " + commandName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
