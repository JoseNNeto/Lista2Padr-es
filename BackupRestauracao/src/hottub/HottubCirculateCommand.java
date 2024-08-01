package hottub;

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
    
}
