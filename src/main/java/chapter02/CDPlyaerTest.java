package chapter02;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author NikoBelic
 * @create 26/12/2016 14:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CDPlayerConfig.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class CDPlyaerTest
{
    @Autowired
    private CompactDisc cd;

    @Test
    public void componentTest()
    {
        cd.play();
    }
}
