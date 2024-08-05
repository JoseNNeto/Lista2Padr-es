package hottub;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;

public class HottubCirculateCommand implements Command {
    private Hottub hottub;

    public HottubCirculateCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.circulateOn();
    }

    public void undo() {
        hottub.circulateOff();
    }

    @Override
    public void store() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("commands.txt", true))) {
            writer.write("HottubCirculatesOn" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            List<String> commands = Files.readAllLines(Paths.get("commands.txt"));
            for (String command : commands) {
                if (command.equals("HottubCirculatesOn")) {
                    execute();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
