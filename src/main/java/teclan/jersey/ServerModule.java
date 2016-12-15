package teclan.jersey;

import org.reflections.Reflections;

import com.google.inject.AbstractModule;

public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Reflections.class)
                .toInstance(new Reflections("teclan.jersey.resource"));
    }
}
