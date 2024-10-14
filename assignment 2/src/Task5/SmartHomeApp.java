class Lights {
    public void on() {
        System.out.println("Lights are On");
    }

    public void off() {
        System.out.println("Lights are Off");
    }
}

class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("Setting temperature to " + temperature);
    }
}

class SecuritySystem {
    public void arm() {
        System.out.println("Security system is armed");
    }

    public void disarm() {
        System.out.println("Security system is disarmed");
    }
}

class EntertainmentSystem {
    public void playMovie(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

class SmartHomeFacade {
    private Lights lights;
    private Thermostat thermostat;
    private SecuritySystem securitySystem;
    private EntertainmentSystem entertainmentSystem;

    public SmartHomeFacade() {
        this.lights = new Lights();
        this.thermostat = new Thermostat();
        this.securitySystem = new SecuritySystem();
        this.entertainmentSystem = new EntertainmentSystem();
    }

    public void leaveHome() {
        lights.off();
        thermostat.setTemperature(18);
        securitySystem.arm();
        System.out.println("Leaving home...");
    }

    public void arriveHome() {
        lights.on();
        thermostat.setTemperature(22);
        securitySystem.disarm();
        System.out.println("Arriving home...");
    }

    public void nightMode() {
        lights.off();
        thermostat.setTemperature(16);
        securitySystem.arm();
        System.out.println("Night mode activated");
    }

    public void movieMode(String movie) {
        lights.off();
        entertainmentSystem.playMovie(movie);
        System.out.println("Movie mode activated");
    }
}

class SmartHomeApp {
    public static void main(String[] args) {
        SmartHomeFacade home = new SmartHomeFacade();
        home.arriveHome();
        home.movieMode("Inception");
        home.nightMode();
        home.leaveHome();
    }
}
