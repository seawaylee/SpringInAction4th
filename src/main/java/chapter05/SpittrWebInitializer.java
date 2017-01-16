package chapter05;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 配置DispatcherServlet
 * @author NikoBelic
 * @create 30/12/2016 10:43
 */
public class SpittrWebInitializer //extends AbstractAnnotationConfigDispatcherServletInitializer
{
    /**
     * 指定ContextLoaderListener配置类
     * @Author NikoBelic
     * @Date 30/12/2016 10:48
     */
    //@Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?>[]{RootConfig.class};
    }


    /**
     * 指定SpringMVC配置类
     * @Author NikoBelic
     * @Date 30/12/2016 10:49
     */
    //@Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * 将DispatcherServlet映射到 "/"
     * @Author
     * @Date 30/12/2016 10:44
     */
    //@Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
