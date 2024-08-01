package tv;

import command.Command;

public class TvCommand implements Command {
    private Tv tv;

    public TvCommand(Tv tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.on();
    }

    public void undo() {
        tv.off();
    }
}
