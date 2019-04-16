package war;

import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class ProviderTest {

    @Test
    public void getWeatherByZip() {
        Provider provider = new Provider();
        Response response = provider.getWeatherByZip("94040");
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void getWeatherByCity() {
        Provider provider = new Provider();
        Response response = provider.getWeatherByCity("Kharkiv");
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
}