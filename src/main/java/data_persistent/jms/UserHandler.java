package data_persistent.jms;

import data_persistent.model.UserObj;
import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 04/02/2017 10:13
 */
@Component
public class UserHandler
{
    public UserHandler()
    {
        System.out.println("User异步消息监听器被初始化");
    }

    public void handleUserAlert(UserObj userObj)
    {
        System.out.println("异步消息监听器收到了一条消息:" + userObj);
    }
}
