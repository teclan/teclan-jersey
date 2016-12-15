package teclan.jersey.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;

@Path("/post")
public class PostResource {

    @Path("/simple")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String postQueryPatameters(@FormParam("id") String id,
            @FormParam("name") String name) {
        System.out.println(String.format("id : %s,\tname : %s", id, name));
        return "SECCESS";
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String postPatameters(MultivaluedMap<String, String> formParams) {

        for (String key : formParams.keySet()) {
            System.out.println(key + " : " + formParams.get(key));
        }
        return "SECCESS";
    }

}
