package data_persistent.config;

import data_persistent.webservice.UserService;
import data_persistent.webservice.UserWebService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import java.net.URL;

/**
 * JAX-WS配置
 * @author NikoBelic
 * @create 27/01/2017 16:33
 */
@Configuration
public class RMIConfig
{
    /**
     * JAX-WS服务端配置
     * @Author NikoBelic
     * @Date 30/01/2017 22:57
     */
    @Bean
    public SimpleJaxWsServiceExporter jaxWsServiceExporter()
    {
        System.out.println("RMI配置文件初始化");
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress("http://localhost:8088/services/");
        return exporter;
    }
}
