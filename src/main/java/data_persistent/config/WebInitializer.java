package data_persistent.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author NikoBelic
 * @create 22/01/2017 15:46
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    public WebInitializer()
    {
        System.out.println("全局配置文件初始化");
    }

    /**
     * 指定ContextLoaderListener配置类
     * @Author NikoBelic
     * @Date 30/12/2016 10:48
     */
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?>[]{RootConfig.class};
    }


    /**
     * 指定SpringMVC配置类
     * @Author NikoBelic
     * @Date 30/12/2016 10:49
     */
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 将DispatcherServlet映射到 "/"
     * @Author
     * @Date 30/12/2016 10:44
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
