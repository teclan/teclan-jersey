package teclan.jersey;

import static us.monoid.web.Resty.delete;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.monoid.web.Resty;

public class DeleteTest {
    private final Logger        LOGGER     = LoggerFactory
            .getLogger(DeleteTest.class);
    private static final String DELETE_URL = "http://localhost:%d/delete/%s";

    @Test
    public void deleteTest() {
        Resty resty = new Resty();
        try {
            LOGGER.info("{}", resty
                    .text(String.format(DELETE_URL, Main.PORT, 700), delete()));
        } catch (Exception e) {
        }

    }

}
