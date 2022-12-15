package es.ull.patrones.api;


import es.ull.patrones.pattern.WeatherData;
import es.ull.patrones.weather.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJSON {

    WeatherData weatherData;

    public ParseJSON (String data) {
        doParsing(data);
    }

    public void doParsing(String data) {
        JSONObject ob = new JSONObject(data);

        // Coordinate object
        float lon = ob.getJSONObject("coord").getFloat("lon");
        float lat = ob.getJSONObject("coord").getFloat("lat");

        Coordinate coordinate = new Coordinate(lon, lat);

        // Weather object
        JSONArray arr = ob.getJSONArray("weather");
        int ID_weather = 0;
        String main= null, description = null, icon = null;
        for (int i = 0; i < arr.length(); ++i) {
            ID_weather = arr.getJSONObject(i).getInt("id");
            main = arr.getJSONObject(i).getString("main");
            description = arr.getJSONObject(i).getString("description");
            icon = arr.getJSONObject(i).getString("icon");
        }

        Weather weather = new Weather(ID_weather, main, description, icon);

        String base = (String) ob.get("base");

        // Main object
        float temp = ob.getJSONObject("main").getFloat("temp");
        float feelsLike = ob.getJSONObject("main").getFloat("feels_like");
        float tempMin = ob.getJSONObject("main").getFloat("temp_min");
        float tempMax = ob.getJSONObject("main").getFloat("temp_max");
        float pressure = ob.getJSONObject("main").getFloat("pressure");
        float humidity = ob.getJSONObject("main").getFloat("humidity");

        MainW mainW = new MainW(temp, feelsLike, tempMin, tempMax, pressure, humidity);

        int visibility = (int) ob.get("visibility");

        // Wind object
        float speed = ob.getJSONObject("wind").getFloat("speed");
        float deg = ob.getJSONObject("wind").getFloat("deg");
        float gust = ob.getJSONObject("wind").getFloat("gust");

        Wind wind = new Wind(speed, deg, gust);

        // Cloud object
        int all = ob.getJSONObject("clouds").getInt("all");

        Cloud cloud = new Cloud(all);

        int dt = (int) ob.get("dt");

        // SystemW object
        int type = ob.getJSONObject("sys").getInt("type");
        int id_Sys = ob.getJSONObject("sys").getInt("id");
        String country = ob.getJSONObject("sys").getString("country");
        int sunrise = ob.getJSONObject("sys").getInt("sunrise");
        int sunset = ob.getJSONObject("sys").getInt("sunset");

        SystemW sys = new SystemW(type, id_Sys, country, sunrise, sunset);

        int timeZone = (int) ob.get("timezone");

        int ID = (int) ob.get("id");

        String name = (String) ob.get("name");

        int cod = (int) ob.get("cod");

        // Creating WeatherData object
        weatherData = new WeatherData(coordinate, weather, base, mainW, visibility, wind, cloud, dt, sys, timeZone, ID, name, cod);
    }

    public WeatherData  getWeatherData() {
        return weatherData;
    }
}
