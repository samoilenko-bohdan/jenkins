package war;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

import javax.ws.rs.core.Response;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void getWeather() throws IOException {
        WebClient client = WebClient.create("http://api.openweathermap.org/data/2.5/weather?" +
                "APPID=8c284eaf2053d6cc7c76b5052fdc0362&units=metric&zip=94040");
        Response response = client.accept("application/json").get();

        String expectedWeather = IOUtils.toString((InputStream)response.getEntity());
        Client.getWeather("zip=94040");
        String actualWeather = Client.getFullWeather();
        assertEquals(expectedWeather, actualWeather);
    }
}