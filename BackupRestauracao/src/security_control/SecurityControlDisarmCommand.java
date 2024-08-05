package security_control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import command.Command;

public class SecurityControlDisarmCommand implements Command {
    private SecurityControl securityControl;

    public SecurityControlDisarmCommand(SecurityControl securityControl) {
        this.securityControl = securityControl;
    }

    public void execute() {
        securityControl.arm();
    }

    public void undo() {
        securityControl.disarm();
    }

    @Override
    public void store() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("commands.txt", true))) {
            writer.write("SecurityControlDisarm" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        try {
            List<String> commands = Files.readAllLines(Paths.get("commands.txt"));
            for (String command : commands) {
                if (command.equals("SecurityControlDisarm")) {
                    execute();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
