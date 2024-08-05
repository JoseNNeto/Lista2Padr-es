package sound;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;

public class SoundOffCommand implements Command{
    private Sound sound;

    public SoundOffCommand(Sound sound) {
        this.sound = sound;
    }

    @Override
    public void execute() {
        sound.off();
    }

    @Override
    public void undo() {
        sound.on();
    }

    @Override
    public void store() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("commands.txt", true))) {
            writer.write("SoundOff" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            List<String> commands = Files.readAllLines(Paths.get("commands.txt"));
            for (String command : commands) {
                if (command.equals("SoundOff")) {
                    execute();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
