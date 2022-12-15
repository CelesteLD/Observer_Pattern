package es.ull.patrones.app;

import es.ull.patrones.gui.MainFrame;

public class App {

    public App() { }

    public void run() {
        /*double lon = -16.8609800;
        double lat = 28.3745800;
        WeatherAPI APIreaded = new WeatherAPI(lon, lat);

        APIreaded.callAPI(lon, lat);

        ParseJSON parse = new ParseJSON(APIreaded.getData());

        EventManager manager = new EventManager(parse.getWeatherData());
        ConcreteListener jpanel = new ConcreteListener();
        manager.subscribe(jpanel);
        // Llamar a este método cuando se apriete el boton de actualizar
        manager.notifyUpdate();*/

        MainFrame frame = new MainFrame();
    }
}
