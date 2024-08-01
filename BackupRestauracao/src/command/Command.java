package command;
public interface Command {
    public void execute();
    public void undo();
    public void store();
    public void load();
}
