package tv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;

public class TvChannelCommand implements Command {
    private Tv tv;
    private int channel;

    public TvChannelCommand(Tv tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    public void execute() {
        tv.setInputChannel(channel);
    }

    public void undo() {
        System.out.println("De volta ao canal anterior");
    }

    @Override
    public void store() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("commands.txt", true))) {
            writer.write("TvChannel" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            List<String> commands = Files.readAllLines(Paths.get("commands.txt"));
            for (String command : commands) {
                if (command.equals("TvChannel")) {
                    execute();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
