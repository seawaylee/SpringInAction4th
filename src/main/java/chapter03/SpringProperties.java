package chapter03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 27/12/2016 22:22
 */
@Component
public class SpringProperties
{
    public SpringProperties(
            @Value("#{systemProperties['user.name']}") String username,
            @Value("#{systemProperties['']}") String password)
    {
        System.out.println("SpEl表达式");
        System.out.println(username + "," + password);
    }
}
