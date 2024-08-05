package tv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;

public class TvVolumeCommand implements Command {
    private Tv tv;
    private int volume;

    public TvVolumeCommand(Tv tv, int volume) {
        this.tv = tv;
        this.volume = volume;
    }

    public void execute() {
        tv.setVolume(volume);
    }

    public void undo() {
        tv.setVolume(0);
    }

    @Override
    public void store() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("commands.txt", true))) {
            writer.write("TvVolume" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            List<String> commands = Files.readAllLines(Paths.get("commands.txt"));
            for (String command : commands) {
                if (command.equals("TvVolume")) {
                    execute();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
