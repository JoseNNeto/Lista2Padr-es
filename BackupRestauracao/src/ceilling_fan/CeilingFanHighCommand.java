package ceilling_fan;

import command.Command;

public class CeilingFanHighCommand implements Command{
    private CeilingFan ceilingFan;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        ceilingFan.high();
    }

    public void undo() {
        ceilingFan.off();
    }
    
}
