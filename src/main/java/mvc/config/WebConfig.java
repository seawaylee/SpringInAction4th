package mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * DispatcherServlet配置
 * @author NikoBelic
 * @create 09/01/2017 20:35
 */
@Configuration
@EnableWebMvc
@ComponentScan("mvc.controller")
public class WebConfig extends WebMvcConfigurerAdapter
{

}