package sound;

import command.Command;

public class SoundCdCommand implements Command {
    private Sound sound;

    public SoundCdCommand(Sound sound) {
        this.sound = sound;
    }

    public void execute() {
        sound.setCd();
    }

    public void undo() {
        System.out.println("Cd removido");
    }
    
}
