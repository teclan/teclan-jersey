package teclan.jersey;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static int PORT = 25501;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ServerModule());
        Server server = injector.getInstance(Server.class);
        server.serPort(PORT); // 可以省略，默认端口 3770
        server.run();

    }
}
