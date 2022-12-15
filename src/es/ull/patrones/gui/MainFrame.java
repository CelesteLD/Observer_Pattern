package es.ull.patrones.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    JPanel firstPanel = new JPanel();
    JLabel textTop = new JLabel();
    JLabel image = new JLabel();
    JComboBox optionBox = new JComboBox();
    JLabel logo = new JLabel();
    JLabel dec = new JLabel();
    JLabel dec2 = new JLabel();
    JButton go = new JButton();


    String towns[] = {"Buenavista del Norte", "El Tanque",
            "Garachico", "Guia De Isora", "Güimar", "Icod de los Vinos",
            "La Guancha", "Los Realejos"};

    double lon[] = {-16.8609800, -16.7805300,
            -16.7634200, -16.7794700, -16.4082900, -16.7118800,
            -16.6607900, -16.5910400};

    double lat[] = {28.3745800, 28.3391600,
            28.3736500, 28.2115400, 28.2737100, 28.3724100,
            28.3729400, 28.3819800};
    public MainFrame() {
        setLocationRelativeTo(this);
        setTitle("Application");
        setBounds(500, 150,1000, 700);
        setContentPane(setFirstPanel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel setFirstPanel() {
        firstPanel.setVisible(true);
        firstPanel.setBackground(new Color(248, 172, 86));
        firstPanel.setLayout(null);


        textTop = setLabel("Choose the town you want", 330, 20, 50, 500);
        firstPanel.add(textTop);

        image = setLabelsImage("img/tnf.png", 250, 150, 700, 500);
        firstPanel.add(image);

        logo = setLabelsImage("img/logo.png", 20, 20, 150, 80);
        firstPanel.add(logo);

        dec = setLabelsImage("img/time.png", 30, 150, 200, 100);
        firstPanel.add(dec);

        dec2 = setLabelsImage("img/storm.png", 30, 270, 200, 200);
        firstPanel.add(dec2);

        optionBox = setOptions();
        firstPanel.add(optionBox);

        go = setButton();
        firstPanel.add(go);

        return firstPanel;

    }

    public JLabel setLabel(String text, int x, int y,int width, int height) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setVisible(true);
        label.setBounds(x, y, height, width);
        label.setFont(new Font("Georgia", Font.BOLD, 30));
        return label;
    }

    public JLabel setLabelsImage(String text, int x, int y, int height, int width) {
        ImageIcon image = new ImageIcon(text);
        JLabel label = new JLabel();
        label.setBounds(x, y, height, width);

        label.setIcon(new ImageIcon(image.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT)));
        label.setVisible(true);
        return label;
    }

    public JComboBox setOptions() {

        JComboBox box = new JComboBox(towns);
        box.setBackground(new Color(236, 119, 55));
        box.setFont(new Font("Georgia", Font.BOLD, 14));
        box.setBounds(45, 500, 200, 30);
        box.setVisible(true);

        return box;
    }

    public JButton setButton() {
        JButton aux = new JButton();
        aux.setVisible(true);
        aux.setText("See info");
        aux.setFont(new Font("Georgia", Font.ITALIC + Font.BOLD, 25));
        aux.setBackground(new Color(233, 194, 150));
        aux.setBounds(45, 550, 200, 50);

        aux.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double longitude = lon[optionBox.getSelectedIndex()];
                double latitude = lat[optionBox.getSelectedIndex()];

                // Reading the API for the option selected
                /*WeatherAPI APIreaded = new WeatherAPI(longitude, latitude);
                APIreaded.callAPI(longitude, latitude);

                // Parsing content
                ParseJSON parse = new ParseJSON(APIreaded.getData());

                EventManager manager = new EventManager(parse.getWeatherData());
                ConcreteListener jpanel = new ConcreteListener();
                manager.subscribe(jpanel);

                manager.notifyUpdate();*/

                SecondFrame secondFrame = new SecondFrame(longitude, latitude);
            }
        });
        return aux;
    }

}
