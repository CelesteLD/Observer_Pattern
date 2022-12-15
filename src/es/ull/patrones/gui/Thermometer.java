package es.ull.patrones.gui;


import org.jfree.chart.plot.JThermometer;

import java.awt.*;

public class Thermometer {
    JThermometer thermometer = new JThermometer();

    public Thermometer(double temperature) {
        thermometer.setValue(temperature);
        thermometer.setBounds(20, 20, 100, 300);
        thermometer.setVisible(true);
        thermometer.setOutlinePaint(null);
        thermometer.setUnits(0);
        thermometer.setForeground(Color.BLACK);
        thermometer.setBackground(Color.WHITE);
        thermometer.setRange(0.0, 40.0);

        thermometer.setSubrangeInfo(2, 30.0, 40.0, 22.0, 40.0);
        thermometer.setSubrangeInfo(1, 20, 30, 18.0, 26.0);
        thermometer.setSubrangeInfo(0, 0.0, 20, 0.0, 100.0);
        thermometer.addSubtitle("Actual Temperature", new Font("Georgia", Font.ITALIC + Font.BOLD, 25));
    }

    public JThermometer getThermometer() {
        return thermometer;
    }

    public void setThermometer(JThermometer thermometer) {
        this.thermometer = thermometer;
    }
}
