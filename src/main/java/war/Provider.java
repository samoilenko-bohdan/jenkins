package war;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/weather")
public class Provider {



    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/zip/{zip}")
    public Response getWeatherByZip(@PathParam("zip") String zip) {
        return Response.ok().entity(Client.getWeather("zip=" + zip)).build();
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/city/{city}")
    public Response getWeatherByCity(@PathParam("city") String city) {
        return Response.ok().entity(Client.getWeather("q=" + city)).build();
    }
}

