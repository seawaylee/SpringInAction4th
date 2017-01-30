package data_persistent.config;

import data_persistent.webservice.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

/**
 * @author NikoBelic
 * @create 30/01/2017 23:09
 */
//@Configuration
public class RMIProxyConfig
{

    //@Bean
    public JaxWsPortProxyFactoryBean proxyUserService()
    {
        System.out.println("初始化远程代理配置");
        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
        proxy.setEndpointAddress("http://localhost:8088/services/userService?wsdl");
        proxy.setServiceName("userService");
        proxy.setPortName("userServiceHttpPort");
        proxy.setServiceInterface(UserService.class);
        proxy.setNamespaceUri("http://user.com");
        return proxy;
    }
}
