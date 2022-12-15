package es.ull.patrones.weather;

public class SystemW {

    int type;
    int ID_system;
    String country;
    int sunrise;
    int sunset;

    public SystemW(int type, int ID_system, String country, int sunrise, int sunset) {
        setType(type);
        setID_system(ID_system);
        setCountry(country);
        setSunrise(sunrise);
        setSunset(sunset);
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setID_system(int ID_system) {
        this.ID_system = ID_system;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public int getType() {
        return type;
    }

    public int getID_system() {
        return ID_system;
    }

    public String getCountry() {
        return country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

}
