package mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author NikoBelic
 * @create 09/01/2017 20:30
 */
@Configuration
@ComponentScan(value = {"mvc.utils.*"} )
public class RootConfig
{
}
