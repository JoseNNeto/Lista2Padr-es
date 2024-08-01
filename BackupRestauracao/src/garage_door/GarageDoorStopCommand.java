package garage_door;

import command.Command;

public class GarageDoorStopCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorStopCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        garageDoor.stop();
    }

    public void undo() {
        garageDoor.down();
    }
    
}
