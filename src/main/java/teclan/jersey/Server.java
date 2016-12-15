package teclan.jersey;

import java.net.URI;
import java.util.Set;

import javax.ws.rs.Path;

import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import io.netty.channel.Channel;

@Singleton
public class Server {
    private final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static int    PORT   = 3770;
    private Injector     injector;

    @Inject
    public Server(Injector injector) {
        this.injector = injector;

    }

    public void run() {
        Reflections reflections = injector.getInstance(Reflections.class);

        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Path.class);

        ResourceConfig resourceConfig = new ResourceConfig(classes);
        // NOTE
        // Teclan
        // 千万不要省略 url 末尾的 /，如果省略了该 /，即使在路由映射（Path注解时）在最前面加上 /，也将导致路由映射错误
        String url = String.format("http://localhost:%d/", PORT);
        URI BASE_URI = URI.create(url);
        final Channel server = NettyHttpContainerProvider
                .createHttp2Server(BASE_URI, resourceConfig, null);

        LOGGER.info("Server start at {}", url);
    }

    public void serPort(int port) {
        PORT = port;
    }
}
