package data_persistent.test;

import data_persistent.config.JMSConfig;
import data_persistent.config.RootConfig;
import data_persistent.model.UserObj;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

/**
 * @author NikoBelic
 * @create 03/02/2017 15:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {JMSConfig.class})
@ContextConfiguration(value = "classpath*:spring/applicationContext-jms.xml")
public class JMSTest
{
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    ActiveMQQueue queue;
    /**
     * 原生JMS发送消息
     * @Author NikoBelic
     * @Date 03/02/2017 16:10
     */
    @Test
    public void sendMsg()
    {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try
        {
            conn = cf.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("user.queue");

            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setText("Hello ActiveMq");
            producer.send(message);
        } catch (JMSException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (session != null)
                    session.close();
                if (conn != null)
                    conn.close();
            } catch (JMSException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * 原生JMS接收消息
     * @Author NikoBelic
     * @Date 03/02/2017 16:10
     */
    @Test
    public void getMsg()
    {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try
        {
            conn = cf.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("user.queue");

            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Got a message: " + textMessage.getText());
            conn.start();
        } catch (JMSException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (session != null)
                    session.close();
                if (conn != null)
                    conn.close();
            } catch (JMSException e)
            {
                e.printStackTrace();
            }
        }
    }

    // ----------------------华丽的分割线----------------------
    /**
     * 异步发送消息
     * @Author NikoBelic
     * @Date 03/02/2017 18:13
     */
    @Test
    public void easySendMsg()
    {
        for (int i = 0; i < 100; i++)
        {
            // 方法二
            UserObj userObj = new UserObj(i, "NikoBleic", "12345", "None");
            jmsTemplate.convertAndSend(userObj);
        }

        // 方法一
        //jmsTemplate.send(queue, session -> {
        //    return session.createTextMessage(userObj.toString());
        //});

    }

    /**
     * 同步接收消息
     * @Author NikoBelic
     * @Date 03/02/2017 18:14
     */
    @Test
    public void easyGetMsg() throws JMSException
    {
        while (true)
        {
            try
            {
                //TextMessage message = (TextMessage) jmsTemplate.receive();
                //System.out.println(message.getText());
                Message message = jmsTemplate.receive();
                if (message instanceof ObjectMessage)
                {
                    System.out.println("JMS模板接收到了消息:" + ((ObjectMessage) message).getObject());
                    System.out.println("");
                }
                else
                {
                    System.out.println("Other Type..." + message.getJMSType());
                }

            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }
    }

}
