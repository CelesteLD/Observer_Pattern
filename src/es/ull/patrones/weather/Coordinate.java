package es.ull.patrones.weather;

public class Coordinate {
    float lon;
    float lat;

    public Coordinate(float lon, float lat) {
        setLon(lon);
        setLat(lat);
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }
    
}
