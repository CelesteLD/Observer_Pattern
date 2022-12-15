package es.ull.patrones.gui;

import es.ull.patrones.api.ParseJSON;
import es.ull.patrones.api.WeatherAPI;
import es.ull.patrones.pattern.ConcreteListener;
import es.ull.patrones.pattern.EventManager;
import es.ull.patrones.pattern.WeatherData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondFrame extends JFrame {

    JPanel firstPanel = new JPanel();
    JPanel left = new JPanel();
    JPanel right = new JPanel();
    JButton exit = new JButton();
    JButton update = new JButton();
    JLabel name = new JLabel();
    JTextArea textArea = new JTextArea();
    double lon, lat;

    EventManager manager;


    public SecondFrame(double longitude, double latitude) {
        this.lon = longitude;
        this.lat = latitude;

        setLocationRelativeTo(this);
        setTitle("Information");
        setBounds(500, 150,1000, 700);
        setContentPane(setSecondPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel setSecondPanel() {

        WeatherAPI APIreaded = new WeatherAPI(lon, lat);
        APIreaded.callAPI(lon, lat);

        // Parsing content
        WeatherData data;
        ParseJSON parse = new ParseJSON(APIreaded.getData());
        data = parse.getWeatherData();

        // LEFT
        firstPanel.setLayout(null);
        left.setBackground(Color.WHITE);
        left.setBounds(0, 0, 500, 700);
        left.setVisible(true);

        name = setLabel(data.getName(), 10,30,200, 50);
        left.add(name);


        name = setLabel("", 10,30,200, 50);
        left.add(name);

        Thermometer ther = new Thermometer(data.getMain().getTemp() - 273.15);
        left.add(ther.getThermometer());

        firstPanel.add(left);
        firstPanel.revalidate();
        firstPanel.repaint();

        update = setButton("Update Info", 50, 500);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                left.remove(ther.getThermometer());
                manager = new EventManager(data);
                manager.subscribe(new ConcreteListener());

                right.remove(textArea);
                textArea = manager.notifyUpdate();
                Thermometer ther = new Thermometer(data.getMain().getTemp() - 273.15);
                left.add(ther.getThermometer());
            }
        });
        left.add(update);


        // RIGHT

        right.setBackground(Color.WHITE);
        right.setLayout(null);
        right.setBounds(500, 0, 500, 700);
        right.setVisible(true);

        // En este panel se añadirán los datos de la API
        exit = setButton("Go Back", 200, 600);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        right.add(exit);

        textArea = showInformation(data);
        right.add(textArea);

        firstPanel.add(right);
        firstPanel.revalidate();
        firstPanel.repaint();

        return firstPanel;
    }

    public JButton setButton(String text, int x, int y) {
        JButton aux = new JButton();
        aux.setVisible(true);
        aux.setText(text);
        aux.setFont(new Font("Georgia", Font.ITALIC + Font.BOLD, 25));
        aux.setBackground(new Color(255, 146, 2));
        aux.setBounds(x, y, 200, 50);
        return aux;
    }

    public JLabel setLabel(String text, int x, int y,int width, int height) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setVisible(true);
        label.setBounds(x, y, height, width);
        label.setFont(new Font("Georgia", Font.BOLD, 30));
        return label;
    }

    public JTextArea showInformation(WeatherData weatherData) {
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
