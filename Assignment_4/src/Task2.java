import java.util.ArrayList;
import java.util.List;

interface WeatherDisplay {
    void update(float temp, float humidity, float pressure);
}

class WeatherStation {
    private List<WeatherDisplay> displays = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void addDisplay(WeatherDisplay display) {
        displays.add(display);
    }

    public void removeDisplay(WeatherDisplay display) {
        displays.remove(display);
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyDisplays();
    }

    private void notifyDisplays() {
        for (WeatherDisplay display : displays) {
            display.update(temperature, humidity, pressure);
        }
    }
}

class CurrentConditionsDisplay implements WeatherDisplay {
    public void update(float temp, float humidity, float pressure) {
        System.out.println("Current conditions: " + temp + "C, " + humidity + "% humidity");
    }
}

class ForecastDisplay implements WeatherDisplay {
    public void update(float temp, float humidity, float pressure) {
        System.out.println("Forecast based on pressure: " + pressure + "hPa");
    }
}


public class Task2 {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        WeatherDisplay currentDisplay = new CurrentConditionsDisplay();
        WeatherDisplay forecastDisplay = new ForecastDisplay();

        station.addDisplay(currentDisplay);
        station.addDisplay(forecastDisplay);

        station.setMeasurements(25, 65, 1010);
        station.setMeasurements(22, 70, 1005);
    }
}
