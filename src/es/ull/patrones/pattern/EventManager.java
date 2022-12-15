package es.ull.patrones.pattern;

import javax.swing.*;
import java.util.ArrayList;

public class EventManager {
    ArrayList<EventListener> listeners = new ArrayList<>();
    WeatherData weatherData;

    public EventManager(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    public void remove(EventListener listener) {
        listeners.remove(listener);
    }

    public JTextArea notifyUpdate() {
        return listeners.get(0).update(weatherData);
    }
}
