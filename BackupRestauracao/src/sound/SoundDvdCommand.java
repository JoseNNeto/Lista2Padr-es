package sound;

import command.Command;

public class SoundDvdCommand implements Command {
    private Sound sound;

    public SoundDvdCommand(Sound sound) {
        this.sound = sound;
    }

    public void execute() {
        sound.setDvd();
    }

    public void undo() {
        System.out.println("Dvd removido");
    }
    
}
