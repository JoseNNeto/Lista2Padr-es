package tv;

import command.Command;

public class TvChannelCommand implements Command {
    private Tv tv;
    private int channel;

    public TvChannelCommand(Tv tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    public void execute() {
        tv.setInputChannel(channel);
    }

    public void undo() {
        System.out.println("De volta ao canal anterior");
    }
    
}
