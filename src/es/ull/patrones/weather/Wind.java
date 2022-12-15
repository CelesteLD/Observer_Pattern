package es.ull.patrones.weather;

public class Wind {

    float speed;
    float deg;
    float gust;

    public Wind(float speed, float deg, float gust) {
        setSpeed(speed);
        setDeg(deg);
        setGust(gust);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    public void setGust(float gust) {
        this.gust = gust;
    }

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }

    public float getGust() {
        return gust;
    }

}
