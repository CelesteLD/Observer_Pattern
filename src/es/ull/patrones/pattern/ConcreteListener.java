package es.ull.patrones.pattern;

import javax.swing.*;
import java.awt.*;

public class ConcreteListener implements EventListener {

    JTextArea textArea = new JTextArea();
    @Override
    public JTextArea update(WeatherData weatherData) {
        textArea.setEditable(false);
        textArea.setVisible(true);
        textArea.setBackground(new Color(242, 187, 115));
        textArea.setFont(new Font("Georgia", Font.BOLD, 14));
        textArea.setBounds(50, 30, 400, 550);

        textArea.setText("\n# -- NAME :" + weatherData.getName() + "\n");
        textArea.append("\n# -- Coordenadas: [LON] = " + weatherData.getCoordinate().getLon() + " [LAT] = " +  weatherData.getCoordinate().getLat() + "\n");
        textArea.append("\n# -- Weather:  [ID]: " + weatherData.getWeather().getID_weather() + " [main]: " + weatherData.getWeather().getMain());
        textArea.append("\n[descr]: " + weatherData.getWeather().getDescription() + " [icon]: " + weatherData.getWeather().getIcon() + "\n");
        textArea.append("\n# -- Base: " + weatherData.getBase() + "\n");
        textArea.append("\n# -- Main: [temp]: " + weatherData.getMain().getTemp() + " [temp_min]: " + weatherData.getMain().getTempMin() );
        textArea.append("\n[temp_max]: " + weatherData.getMain().getTemMax() + weatherData.getMain().getTemp() + " [pressure]: " + weatherData.getMain().getPressure());
        textArea.append("\n[humidity]: " + weatherData.getMain().getHumidity() + "\n");
        textArea.append("\n# -- Visibility: " + weatherData.getVisibility() + "\n");
        textArea.append("\n# -- Wind: [speed]: " + weatherData.getWind().getSpeed() + " [deg]: " + weatherData.getWind().getDeg() + "\n");
        textArea.append("\n# -- Clouds: [all]: " + weatherData.getClouds().getAll() + "\n");
        textArea.append("\n# -- Dt: " + weatherData.getDt() + "\n");
        textArea.append("\n# -- Sys: [type]: " + weatherData.getSys().getType() + " [id]: " + weatherData.getSys().getID_system() + " [type]: ");
        textArea.append("\n"+ weatherData.getSys().getType() + " [country]: " + weatherData.getSys().getCountry() + " [sunrise]: ");
        textArea.append("\n" + weatherData.getSys().getSunrise() + " [sunset]: " + weatherData.getSys().getSunset() + "\n");
        textArea.append("\n# -- ID: " + weatherData.getID() + "\n");
        textArea.append("\n# -- Name: " + weatherData.getName() + "\n");
        textArea.append("\n# -- Cod: " + weatherData.getCode() + "\n");

        return textArea;
    }
}
