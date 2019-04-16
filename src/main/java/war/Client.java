package war;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONObject;
import war.entity.Weather;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

public class Client {

    private static String fullWeather;

    public static String getFullWeather() {
        return fullWeather;
    }

//    public static WheatherCXF getWheatherAPIByZip(String zip) {
//        WebClient client = WebClient.create("http://api.openweathermap.org/data/2.5/weather?" +
//                "APPID=8c284eaf2053d6cc7c76b5052fdc0362&units=metric&zip=" + zip);
//        Response response = client.accept("application/json").get();
//        MappingJsonFactory factory = new MappingJsonFactory();
//        JsonParser parser = null;
//        WheatherCXF wheatherCXF = null;
//        try {
//            parser = factory.createJsonParser((InputStream)response.getEntity());
//            wheatherCXF = parser.readValueAs(WheatherCXF.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return wheatherCXF;
//    }
//
//    public static WheatherCXF getWheatherAPIByCity(String city) {
//        WebClient client = WebClient.create("http://api.openweathermap.org/data/2.5/weather?" +
//                "APPID=8c284eaf2053d6cc7c76b5052fdc0362&units=metric&q=" + city);
//        Response response = client.accept("application/json").get();
//        MappingJsonFactory factory = new MappingJsonFactory();
//        JsonParser parser = null;
//        WheatherCXF wheatherCXF = null;
//        try {
//            parser = factory.createJsonParser((InputStream)response.getEntity());
//            wheatherCXF = parser.readValueAs(WheatherCXF.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return wheatherCXF;
//    }

    public static Weather getWeather(String param) {
        WebClient client = WebClient.create("http://api.openweathermap.org/data/2.5/weather?" +
                "APPID=8c284eaf2053d6cc7c76b5052fdc0362&units=metric&" + param);
        Response response = client.accept("application/json").get();
        Weather weather = new Weather();
        try {
            fullWeather = IOUtils.toString((InputStream)response.getEntity());
            JSONObject json = new JSONObject(fullWeather);
            weather.setClouds(json.getJSONObject("clouds").getInt("all"));
            weather.setCityName(json.getString("name"));
            weather.setDescription(json.getJSONArray("weather").getJSONObject(0).getString("description"));
            weather.setHumidity(json.getJSONObject("main").getInt("humidity"));
            weather.setMain(json.getJSONArray("weather").getJSONObject(0).getString("main"));
            weather.setMaxTemp(json.getJSONObject("main").getInt("temp_max"));
            weather.setMinTemp(json.getJSONObject("main").getInt("temp_min"));
            weather.setTemp(json.getJSONObject("main").getInt("temp"));
            weather.setPressure(json.getJSONObject("main").getInt("pressure"));
            weather.setWindSpeed(json.getJSONObject("wind").getInt("speed"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }

}
