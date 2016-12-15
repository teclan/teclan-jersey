package teclan.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;

@Path("helloworld")
public class HelloWorldResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHello() throws JSONException {
        return new JSONObject().put("data", "hello world !").toString();
    }

}