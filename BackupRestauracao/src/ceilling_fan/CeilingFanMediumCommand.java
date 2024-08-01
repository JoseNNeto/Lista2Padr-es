package ceilling_fan;

import command.Command;

public class CeilingFanMediumCommand implements Command{
    private CeilingFan ceilingFan;

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        ceilingFan.medium();
    }

    public void undo() {
        ceilingFan.off();
    }
    
}
