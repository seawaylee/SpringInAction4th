package data_persistent.test;

import data_persistent.config.WebInitializer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author NikoBelic
 * @create 30/01/2017 22:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebInitializer.class)
public class RMITest
{

}
