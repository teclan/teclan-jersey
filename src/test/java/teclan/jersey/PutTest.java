package teclan.jersey;

import static us.monoid.web.Resty.put;

import org.junit.Test;

import us.monoid.json.JSONObject;
import us.monoid.web.Content;
import us.monoid.web.Resty;
import us.monoid.web.TextResource;

public class PutTest {

    private static final String PUT_URL = "http://localhost:%d/put";

    @Test
    public void putTest() {

        JSONObject obj = new JSONObject();
        try {
            obj.put("id", 1).put("name", "Teclan");
            TextResource textResource = new Resty().text(
                    String.format(PUT_URL, Main.PORT),
                    put(new Content("application/json; charset=utf-8",
                            new JSONObject().put("data", obj).toString()
                                    .getBytes("UTF-8"))));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
