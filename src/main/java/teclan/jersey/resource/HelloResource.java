package teclan.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello/{username}")
public class HelloResource {

    @GET
    @Produces({ MediaType.TEXT_PLAIN, MediaType.TEXT_HTML })
    public String getUser(@PathParam("username") String userName) {
        return "hello " + userName;
    }

    @Path("/info")
    @GET
    public String getUserInfo(@PathParam("username") String userName) {
        return "This is info of " + userName;
    }

}
