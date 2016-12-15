package teclan.jersey;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.monoid.web.Resty;

public class GetTest {
    private static final Logger LOGGER              = LoggerFactory
            .getLogger(GetTest.class);

    private static final String HELLO_WORL_URL      = "http://localhost:%d/helloworld";
    private static final String HELLO_USER_URL      = "http://localhost:%d/hello/%s";
    private static final String HELLO_USER_INFO_URL = "http://localhost:%d/hello/%s/info";

    private static final String DEFAULT_USER_URL    = "http://localhost:%d/default/%s";

    @Test
    public void getJson() {
        try {

            LOGGER.info(
                    new Resty().json(String.format(HELLO_WORL_URL, Main.PORT))
                            .object().toString());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Test
    public void getHelloUser() {
        try {

            LOGGER.info("{}", new Resty()
                    .text(String.format(HELLO_USER_URL, Main.PORT, "Teclan")));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Test
    public void getHelloUserInfo() {
        try {

            LOGGER.info("{}", new Resty().text(
                    String.format(HELLO_USER_INFO_URL, Main.PORT, "Teclan")));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Test
    public void getDefaultUser() {
        try {

            LOGGER.info("{}", new Resty()
                    .text(String.format(DEFAULT_USER_URL, Main.PORT, 88)));
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
