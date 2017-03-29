package mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * @author NikoBelic
 * @create 09/01/2017 20:29
 */
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    /**
     * Spring上下文配置
     * ContextLoaderListener
     * @Author NikoBelic
     * @Date 09/01/2017 20:40
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * SpringMVC上下文配置
     * DisparcherServlet
     * @Author NikoBelic
     * @Date 09/01/2017 20:41
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * SpringMVC请求拦截,将DispatcherServlet映射到/
     * @Author NikoBelic
     * @Date 09/01/2017 20:41
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置文件上传限制
     * @Author NikoBelic
     * @Date 09/01/2017 20:40
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("/Users/lixiwei-mac/Desktop/tmp",20971520, 41943040, 0));
    }
}
