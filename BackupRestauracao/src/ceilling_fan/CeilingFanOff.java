package ceilling_fan;

import command.Command;

public class CeilingFanOff implements Command{
    private CeilingFan ceilingFan;

    public CeilingFanOff(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        ceilingFan.off();
    }

    public void undo() {
        ceilingFan.low();
    }
}
