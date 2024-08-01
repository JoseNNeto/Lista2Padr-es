package ceilling_fan;

import command.Command;

public class CeilingFanLowCommand implements Command{
    private CeilingFan ceilingFan;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        ceilingFan.low();
    }

    public void undo() {
        ceilingFan.off();
    }
}
