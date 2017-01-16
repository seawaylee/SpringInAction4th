package chapter03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 27/12/2016 16:25
 */
@Component
@PropertySource("classpath:db.properties")
public class MyProperties
{
    @Autowired
    Environment env;


    public void show()
    {
        System.out.println(env.getProperty("username") + "," + env.getProperty("password"));
    }
}
