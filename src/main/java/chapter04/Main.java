package chapter04;

import org.aspectj.weaver.patterns.PerFromSuper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author NikoBelic
 * @create 28/12/2016 19:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
//@ContextConfiguration(locations = "classpath:spring/c4-applicationContext.xml")
public class Main
{
    @Autowired
    Performance performance;

    @Autowired
    CDPlayer cdPlayer;

    @Test
    public void aopTest()
    {
        performance.perform();
    }


    @Test
    public void aopArgsTest()
    {
        for (int i = 0; i < 10; i++)
        {
            cdPlayer.play(new Random().nextInt(3));
        }
    }

    @Test
    public void aopNewInterfaceTest() throws ClassNotFoundException
    {
        Class<?> clazz = Class.forName("chapter04.CDPlayer");
        Method[] methods = clazz.getMethods();
        for (Method method : methods)
        {
            System.out.println(method.getName());
        }
        cdPlayer.play(1);
    }
}
