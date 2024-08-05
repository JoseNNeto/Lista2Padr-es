package sound;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;

public class SoundVolumeCommand implements Command {
    private Sound sound;
    private int volume;

    public SoundVolumeCommand(Sound sound, int volume) {
        this.sound = sound;
        this.volume = volume;
    }

    public void execute() {
        sound.setVolume(volume);
    }

    public void undo() {
        sound.setVolume(0);
    }

    @Override
    public void store() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("commands.txt", true))) {
            writer.write("SoundVolume" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            List<String> commands = Files.readAllLines(Paths.get("commands.txt"));
            for (String command : commands) {
                if (command.equals("SoundVolume")) {
                    execute();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
