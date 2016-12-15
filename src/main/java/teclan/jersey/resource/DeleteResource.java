package teclan.jersey.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/delete")
public class DeleteResource {

    @DELETE
    @Path("/{id}")
    public void getUser(@PathParam("id") String id) {
        System.out.println("delete " + id);
    }

}
