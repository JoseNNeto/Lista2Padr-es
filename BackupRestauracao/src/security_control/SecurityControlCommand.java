package security_control;

import command.Command;

public class SecurityControlCommand implements Command {
    private SecurityControl securityControl;

    public SecurityControlCommand(SecurityControl securityControl) {
        this.securityControl = securityControl;
    }

    public void execute() {
        securityControl.arm();
    }

    public void undo() {
        securityControl.disarm();
    }
}
