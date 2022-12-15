package es.ull.patrones.weather;


public class MainW {

    float temp;
    float feelsLike;
    float tempMin;
    float temMax;
    float pressure;
    float humidity;

    public MainW(float temp, float feelsLike, float tempMin, float temMax, float pressure, float humidity) {
        setTemp(temp);
        setFeelsLike(feelsLike);
        setTempMin(tempMin);
        setTemMax(temMax);
        setPressure(pressure);
        setHumidity(humidity);
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public void setTemMax(float temMax) {
        this.temMax = temMax;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public float getTempMin() {
        return tempMin;
    }

    public float getTemMax() {
        return temMax;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

}
