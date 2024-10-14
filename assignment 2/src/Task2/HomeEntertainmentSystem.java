package Task2;

interface Device {
    void powerOn();
    void powerOff();
    void setChannel(int channel);
    void setVolume(int volume);
}

class TVDevice implements Device {
    public void powerOn() {
        System.out.println("TV is On");
    }

    public void powerOff() {
        System.out.println("TV is Off");
    }

    public void setChannel(int channel) {
        System.out.println("TV channel set to " + channel);
    }

    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }
}

class DVDDevice implements Device {
    public void powerOn() {
        System.out.println("DVD Player is On");
    }

    public void powerOff() {
        System.out.println("DVD Player is Off");
    }

    public void setChannel(int channel) {
        System.out.println("DVD channel set to " + channel);
    }

    public void setVolume(int volume) {
        System.out.println("DVD volume set to " + volume);
    }
}

class SoundSystemDevice implements Device {
    public void powerOn() {
        System.out.println("Sound System is On");
    }

    public void powerOff() {
        System.out.println("Sound System is Off");
    }

    public void setChannel(int channel) {
        System.out.println("Sound System channel set to " + channel);
    }

    public void setVolume(int volume) {
        System.out.println("Sound System volume set to " + volume);
    }
}

abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.powerOn();
    }

    public void powerOff() {
        device.powerOff();
    }

    public void setChannel(int channel) {
        device.setChannel(channel);
    }

    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}

class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }
}

class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Muting device");
    }
}

class HomeEntertainmentSystem {
    public static void main(String[] args) {
        Device tv = new TVDevice();
        Device dvd = new DVDDevice();
        Device soundSystem = new SoundSystemDevice();

        RemoteControl basicRemoteTV = new BasicRemote(tv);
        RemoteControl basicRemoteDVD = new BasicRemote(dvd);
        RemoteControl advancedRemoteSoundSystem = new AdvancedRemote(soundSystem);

        basicRemoteTV.powerOn();
        basicRemoteTV.setChannel(5); // Now this will work
        basicRemoteDVD.powerOn();
        advancedRemoteSoundSystem.powerOn();
        ((AdvancedRemote) advancedRemoteSoundSystem).mute();
    }
}
