package sound;

import command.Command;

public class SoundVolumeCommand implements Command {
    private Sound sound;
    private int volume;

    public SoundVolumeCommand(Sound sound, int volume) {
        this.sound = sound;
        this.volume = volume;
    }

    public void execute() {
        sound.setVolume(volume);
    }

    public void undo() {
        sound.setVolume(0);
    }
    
}
