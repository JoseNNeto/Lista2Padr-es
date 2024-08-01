package hottub;

import command.Command;

public class HottubTemperatureCommand implements Command {
    private Hottub hottub;
    private int temperature;

    public HottubTemperatureCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        temperature = hottub.getTemperature();
        hottub.setTemperature(temperature + 1);
    }

    public void undo() {
        hottub.setTemperature(temperature);
    }
    
}
