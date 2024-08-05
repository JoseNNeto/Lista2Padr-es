package garage_door;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;

public class GarageDoorStopCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorStopCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.stop();
    }

    public void undo() {
        garageDoor.down();
    }

    @Override
    public void store() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("commands.txt", true))) {
            writer.write("GarageDoorStop" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
       try {
            List<String> commands = Files.readAllLines(Paths.get("commands.txt"));
            for (String command : commands) {
                if (command.equals("GarageDoorStop")) {
                    execute();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
