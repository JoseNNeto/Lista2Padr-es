import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.Command;

public class RemoteControl {
    List<Command> commands = new ArrayList<>();
    Map<String, Command> commandMap = new HashMap<>();

    public RemoteControl() {
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
