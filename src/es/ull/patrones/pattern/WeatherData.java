package es.ull.patrones.pattern;

import es.ull.patrones.weather.*;

public class WeatherData {

    Coordinate coordinate;
    Weather weather;
    String base;
    MainW main;
    int visibility;
    Wind wind;
    Cloud clouds;
    int dt;
    SystemW sys;
    int timeZone;
    int ID;
    String name;
    int code;

    public WeatherData(Coordinate coordinate, Weather weather, String base,
                   MainW main, int visibility, Wind wind, Cloud clouds, int dt, SystemW sys,
                   int timeZone, int ID, String name, int code) {

        setCoordinate(coordinate);
        setWeather(weather);
        setBase(base);
        setMain(main);
        setVisibility(visibility);
        setWind(wind);
        setClouds(clouds);
        setDt(dt);
        setSys(sys);
        setTimeZone(timeZone);
        setID(ID);
        setName(name);
        setCode(code);
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setMain(MainW main) {
        this.main = main;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setClouds(Cloud clouds) {
        this.clouds = clouds;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setSys(SystemW sys) {
        this.sys = sys;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

   public Coordinate getCoordinate() {
        return coordinate;
    }

    public Weather getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public MainW getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public int getDt() {
        return dt;
    }

    public SystemW getSys() {
        return sys;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    // Method for show all the information
    public void showWeatherData() {
        System.out.println("# -- Coordenadas: " + coordinate.getLon() + " " + coordinate.getLat());
        System.out.println("# -- Weather: [ID]: " + weather.getID_weather() + " [main]: " + weather.getMain() + " [descr]: " + weather.getDescription() + " [icon]: " + weather.getIcon());
        System.out.println("# -- Base: " + base);
        System.out.println("# -- Main: [temp]: " + " [temp_min]: " + main.getTempMin() + " [temp_max]: " + main.getTemMax() + main.getTemp() + " [pressure]: " + main.getPressure() + " [humidity]: " + main.getHumidity());
        System.out.println("# -- Visibility: " + visibility);
        System.out.println("# -- Wind: [speed]: " + wind.getSpeed() + " [deg]: " + wind.getDeg());
        System.out.println("# -- Clouds: [all]: " + clouds.getAll());
        System.out.println("# -- Dt: " + dt);
        System.out.println("# -- Sys: [type]: " + sys.getType() + " [id]: " + sys.getID_system() + " [type]: " + sys.getType() + " [country]: " + sys.getCountry() + " [sunrise]: " + sys.getSunrise() + " [sunset]: " + sys.getSunset());
        System.out.println("# -- Timezone: " + timeZone);
        System.out.println("# -- ID: " + ID);
        System.out.println("# -- Name: " + name);
        System.out.println("# -- Code: " + code);
    }
}
