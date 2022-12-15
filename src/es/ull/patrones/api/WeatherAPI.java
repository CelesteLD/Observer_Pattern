package es.ull.patrones.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherAPI {

    String API_Key = "xxx"; // generate Key. https://api.openweathermap.org
    double lon;
    double lat;
    String data;

    public WeatherAPI(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
        callAPI(lon, lat);
    }

    public void callAPI(double lon, double lat) {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + API_Key);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("An Error Occurred: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());

                while(sc.hasNext()) {
                    informationString.append(sc.nextLine());
                }
                sc.close();

                data = informationString.toString();

                //ParseJSON parse = new ParseJSON(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getData() {
        return data;
    }
}
