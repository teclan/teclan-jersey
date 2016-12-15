package teclan.jersey;

import static us.monoid.web.Resty.form;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.monoid.web.Resty;

public class PostTest {
    private static final Logger LOGGER            = LoggerFactory
            .getLogger(PostTest.class);
    private static final String POST_QUERY_URL    = "http://localhost:%d/post/simple";
    private static final String POST_URL          = "http://localhost:%d/post";
    private static final String GOOGLE_QUERY_DATA = "id=mg&name=test123456";

    @Test
    public void postTest() {
        try {

            LOGGER.info("{}",
                    new Resty().text(String.format(POST_URL, Main.PORT),
                            form(GOOGLE_QUERY_DATA)).toString());

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    @Test
    public void postSimpleTest() {
        try {

            LOGGER.info("{}",
                    new Resty().text(String.format(POST_QUERY_URL, Main.PORT),
                            form(GOOGLE_QUERY_DATA)).toString());

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

}
