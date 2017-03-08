package data_persistent.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 03/02/2017 14:42
 */
@Configuration(value = "classpath:spring/applicationContext-jms.xml")
//@ComponentScan(basePackages = "data_persistent.jms")
public class JMSConfig
{
    /**
     * 消息队列实例工厂
     * @Author NikoBelic
     * @Date 03/02/2017 18:12
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory()
    {
        System.out.println("AMQFactory Initial...");
        ActiveMQConnectionFactory acf = new ActiveMQConnectionFactory();
        acf.setBrokerURL("tcp://localhost:61616");// 管理界面在http://localhost:8161    admin/admin
        acf.setTrustAllPackages(true);  // 防止出现Obj实现序列化接口也不能正常解析的问题
        return acf;
    }

    /**
     * 消息转换器类型
     * @Author NikoBelic
     * @Date 03/02/2017 18:12
     */
    @Bean
    public MessageConverter messageConverter()
    {
        return new SimpleMessageConverter();
        //return new MappingJackson2MessageConverter();
    }

    /**
     * JMS模板操作
     * @Author NikoBelic
     * @Date 03/02/2017 18:12
     */
    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory, MessageConverter messageConverter, ActiveMQQueue queue)
    {
        System.out.println("JMSTemplate Initial...");
        JmsTemplate jmsTemplate = new JmsTemplate(activeMQConnectionFactory);
        jmsTemplate.setDefaultDestination(queue);
        jmsTemplate.setMessageConverter(messageConverter);
        return jmsTemplate;
    }

    /**
     * 消息队列
     * @Author NikoBelic
     * @Date 03/02/2017 18:12
     */
    @Bean
    public ActiveMQQueue queue()
    {
        ActiveMQQueue amq = new ActiveMQQueue("user.queue");
        return amq;
    }

    /**
     * 主题
     * @Author NikoBelic
     * @Date 03/02/2017 18:13
     */
    @Bean
    public ActiveMQTopic topic()
    {
        System.out.println("Topic初始化");
        ActiveMQTopic topic = new ActiveMQTopic("user.topic");
        return topic;
    }


}
