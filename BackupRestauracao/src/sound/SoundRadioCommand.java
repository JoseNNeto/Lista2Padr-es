package sound;

import command.Command;

public class SoundRadioCommand implements Command {
    private Sound sound;

    public SoundRadioCommand(Sound sound) {
        this.sound = sound;
    }

    public void execute() {
        sound.setRadio();
    }

    public void undo() {
        System.out.println("Radio desligado");
    }
    
}
