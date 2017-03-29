package test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring上下文配置类
 * 由ContextLoaderListener加载的bean
 * @author NikoBelic
 * @create 09/01/2017 20:30
 */
//@Configuration
//@ComponentScan(basePackages = "test")
public class RootConfig
{
    public RootConfig()
    {
        System.out.println("RootConfig初始化");
    }

}
