interface Command {
    void execute();
    void undo();
}

class TV {
    public void turnOn() { System.out.println("TV is ON"); }
    public void turnOff() { System.out.println("TV is OFF"); }
}

class Light {
    public void dim() { System.out.println("Light is DIMMED"); }
    public void bright() { System.out.println("Light is BRIGHT"); }
}

class TurnTVOn implements Command {
    private TV tv;
    public TurnTVOn(TV tv) { this.tv = tv; }
    public void execute() { tv.turnOn(); }
    public void undo() { tv.turnOff(); }
}

class DimLights implements Command {
    private Light light;
    public DimLights(Light light) { this.light = light; }
    public void execute() { light.dim(); }
    public void undo() { light.bright(); }
}

class RemoteControl {
    private Command[] slots = new Command[2];
    private Command undoCommand;

    public void setCommand(int slot, Command command) {
        slots[slot] = command;
    }

    public void pressButton(int slot) {
        if (slots[slot] != null) {
            slots[slot].execute();
            undoCommand = slots[slot];
        }
    }

    public void pressUndo() {
        if (undoCommand != null) {
            undoCommand.undo();
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        TV tv = new TV();
        Light light = new Light();

        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, new TurnTVOn(tv));
        remote.setCommand(1, new DimLights(light));

        remote.pressButton(0);
        remote.pressButton(1);

        remote.pressUndo();
    }
}
