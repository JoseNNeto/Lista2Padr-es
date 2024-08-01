import command.Command;

public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }

    @Override
    public void store() {
        for (Command c : commands) {
            c.store();
        }
    }

    @Override
    public void load() {
        for (Command c : commands) {
            c.load();
        }
    }
    
}
