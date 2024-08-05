package hottub;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;

public class HottubTemperatureCommand implements Command {
    private Hottub hottub;
    private int temperature;

    public HottubTemperatureCommand(Hottub hottub, int temperature) {
        this.hottub = hottub;
        this.temperature = temperature;
    }

    public void execute() {
        temperature = hottub.getTemperature();
        hottub.setTemperature(temperature + 1);
    }

    public void undo() {
        hottub.setTemperature(temperature);
    }

    @Override
    public void store() {
try (BufferedWriter writer = new BufferedWriter(new FileWriter("commands.txt", true))) {
            writer.write("HottubSetTemperature" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            List<String> commands = Files.readAllLines(Paths.get("commands.txt"));
            for (String command : commands) {
                if (command.equals("HottubSetTemperature")) {
                    execute();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
