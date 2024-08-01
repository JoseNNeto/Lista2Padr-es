package hottub;

import command.Command;

public class HottubJetsCommand implements Command {
    private Hottub hottub;

    public HottubJetsCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.jetsOn();
    }

    public void undo() {
        hottub.jetsOff();
    }
    
}
