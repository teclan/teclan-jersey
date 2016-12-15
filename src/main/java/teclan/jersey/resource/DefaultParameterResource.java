package teclan.jersey.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("default/{age}")
public class DefaultParameterResource {
    @DefaultValue("2")
    @QueryParam("userName")
    String userName;

    @DefaultValue("100")
    @QueryParam("age")
    int    age;

    @GET
    @Produces({ MediaType.TEXT_PLAIN, MediaType.TEXT_HTML })
    public String getUser() {
        return "hello " + userName + " your age is " + age;
    }

}
