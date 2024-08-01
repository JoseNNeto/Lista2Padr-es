package tv;

import command.Command;

public class TvVolumeCommand implements Command {
    private Tv tv;
    private int volume;

    public TvVolumeCommand(Tv tv, int volume) {
        this.tv = tv;
        this.volume = volume;
    }

    public void execute() {
        tv.setVolume(volume);
    }

    public void undo() {
        tv.setVolume(0);
    }
    
}
