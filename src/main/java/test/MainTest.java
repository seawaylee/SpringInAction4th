package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.config.RootConfig;
import test.service.BaseService;
import test.service.UserService;
import test.service.UserServiceImpl;

import javax.annotation.Resource;

/**
 * @author NikoBelic
 * @create 08/03/2017 16:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class MainTest
{
    //@Resource(name = "userServiceImpl")
    @Autowired
    private BaseService baseService;

    @Test
    public void test()
    {
        System.out.println(baseService);
    }
}
