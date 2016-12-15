[jersey官方网站](https://jersey.java.net/)
 
### 使用说明
 
 参考 teclan.jersey 下的 Main.class
 ```
  public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ServerModule());
        Server server = injector.getInstance(Server.class);
        server.serPort(PORT); // 可以省略，默认端口 3770
        server.run();
    }
 ```
 其中需要创建 ServerModule 类，如下:
 ```
 public class ServerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Reflections.class)
                .toInstance(new Reflections("teclan.jersey.resource"));
    }
}
```
"teclan.jersey.resource" 是需要具体修改的配置，这是 Resource 所在包名，建议所有的 Resource
都放在同一个包下面，程序会自动加载该包下面的所有被@Path注解的类，就是会自动加载注册所有路由，相关代码参
看 teclan.jersey 下的 Server.class
```
Reflections reflections = injector.getInstance(Reflections.class);
Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Path.class);
ResourceConfig resourceConfig = new ResourceConfig(classes);
```
如果确实在别的包下面存在路由映射，那么请参考Resource的注解方法
```
    public ResourceConfig(final Set<Class<?>> classes) {
        this();
        this.registerClasses(classes);
    }
```


```
    public ResourceConfig(final Class<?>... classes) {
        this(Sets.newHashSet(classes));
    }
```


```
    public ResourceConfig register(final Class<?> componentClass) {
        invalidateCache();
        state.register(componentClass);
        return this;
    }
    
```
 
### 注解说明

#### @Path
路由映射，例如：@Path("/hello")
假设路由为 http://localhost:3770/
如果一个 Resource(Java 类)被Path注解，例如注解内容为 “hello”，那个这个
 类所匹配的路由就是 http://localhost:3770/hello
	
#### @Produces
用于限制post和get方法返回的参数类型，支持json、string、xml、html
范例如下：@Produces({"application/xml", "application/json"}) 或者 @Produces({ MediaType.TEXT_PLAIN, MediaType.TEXT_HTML })
#### @Consumes

用于限制输入的参数的类型，支持json、string、xml、html
范例如下：@Consumes("text/plain") 或者 @Consumes({ MediaType.TEXT_PLAIN, MediaType.TEXT_HTML })

#### @QueryParam
通过request传入的参数，可以转换任何有以String为参数的构造函数的类。

#### @DefaultValue
 
#### GET,POST,PUT,DELETE,OPTION ...
用于方法注解，表示某个方法匹配哪种请求
 
 
 