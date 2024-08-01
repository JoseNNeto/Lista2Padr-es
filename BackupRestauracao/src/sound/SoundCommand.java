package sound;

import command.Command;

public class SoundCommand implements Command {
    private Sound sound;

    public SoundCommand(Sound sound) {
        this.sound = sound;
    }

    public void execute() {
        sound.on();
    }

    public void undo() {
        sound.off();
    }
    
}
