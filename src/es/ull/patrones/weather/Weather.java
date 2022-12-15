package es.ull.patrones.weather;

public class Weather {
    int ID_weather;
    String main;
    String description;
    String icon;

    public Weather(){}
    public Weather(int ID_weather, String main, String description, String icon) {
        setID_weather(ID_weather);
        setMain(main);
        setDescription(description);
        setIcon(icon);
    }

    public void setID_weather(int ID_weather) {
        this.ID_weather = ID_weather;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getID_weather() {
        return ID_weather;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

}
