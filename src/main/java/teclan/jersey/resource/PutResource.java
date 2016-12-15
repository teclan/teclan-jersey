package teclan.jersey.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("put")
public class PutResource {
    @PUT
    @Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    public void putContainer(String data) {
        System.out.println(" put data : " + data);
    }
}
