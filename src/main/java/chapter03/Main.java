package chapter03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author NikoBelic
 * @create 27/12/2016 09:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/c3-applicationContext.xml")
//@ActivePcrofiles("dev")
public class Main
{
    @Autowired
    MagicBeanFactory factory;

    @Autowired
    @Qualifier("dog")
    Animal animal;

    @Autowired
    private MyProperties properties;

    @Autowired
    private SpringProperties springProperties;
    /**
     * 测试profile切换beans
     * @Author NikoBelic
     * @Date 27/12/2016 14:50
     */
    @Test
    public void profileTest()
    {
        System.out.println("测试");
    }

    @Test
    public void conditionTest()
    {
        MagicBean magicBean = factory.magicBean();
        System.out.println(magicBean);
        System.out.println("条件测试");
    }

    @Test
    public void primaryTest()
    {
        System.out.println(animal);
    }

    @Test
    public void propertyTest()
    {
        properties.show();
    }

    @Test
    public void spelTest()
    {
    }
}
