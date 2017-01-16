package chapter05.test;

import chapter05.controller.HomeController;
import chapter05.dao.SpittleRepository;
import chapter05.model.Spittle;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author NikoBelic
 * @create 30/12/2016 14:21
 */
public class HomeControllerTest
{
    /**
     * 测试控制器
     * @Author NikoBelic
     * @Date 30/12/2016 14:24
     */
    @Test
    public void testHomepage() throws Exception
    {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

}
