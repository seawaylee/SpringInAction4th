package chapter05.controller;

import chapter05.model.Spittle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * @author NikoBelic
 * @create 30/12/2016 12:55
 */
@Controller
@RequestMapping("home")
public class HomeController
{
    private static List<Spittle> spittleList;
    private static final int PAGE_SIZE = 5;

    static
    {
        spittleList = createSpittleList(Math.max(10, new Random().nextInt(100)));
        System.out.println("随机生成数据:" + spittleList.size());
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String home()
    {
        return "home";
    }

    /**
     * 获取Spittles
     *
     * @Author NikoBelic
     * @Date 31/12/2016 22:22
     */
    @RequestMapping(value = "spittles/{page}", method = RequestMethod.GET)
    public ModelAndView getSpittles(@PathVariable int page, ModelAndView mv)
    {
        Map<String, Integer> pageInfo = getPageInfo(page, spittleList.size());
        List<Spittle> pageSpittleList = spittleList.subList(pageInfo.get("start"), pageInfo.get("end"));
        mv.setViewName("spittle");
        mv.addObject("spittleList", pageSpittleList);
        mv.addObject("totalPage", pageInfo.get("totalPage"));
        mv.addObject("page", page);
        return mv;
    }


    /**
     * 模拟从数据库获取数据
     *
     * @Author NikoBelic
     * @Date 31/12/2016 13:15
     */
    private static List<Spittle> createSpittleList(int count)
    {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++)
        {
            spittles.add(new Spittle(i, "Spittle " + i, new Date(), null, null));
        }
        return spittles;
    }


    /**
     * 分页工具
     *
     * @Author NikoBelic
     * @Date 31/12/2016 23:39
     */
    private Map<String, Integer> getPageInfo(int page, int totalRecord)
    {
        Map<String, Integer> pageInfo = new HashMap<>();
        int start = (page - 1) * PAGE_SIZE; // 当前页起始index
        int end;
        int totalPage = (int) Math.ceil(totalRecord / (float) PAGE_SIZE);
        if (page != totalPage)
            end = start + PAGE_SIZE;
        else
        {
            if (totalRecord % PAGE_SIZE != 0)
                end = (totalPage - 1) * PAGE_SIZE + totalRecord % PAGE_SIZE;
            else
                end = start + PAGE_SIZE;
        }
        pageInfo.put("start", start);
        pageInfo.put("end", end);
        pageInfo.put("page", page);
        pageInfo.put("totalPage", totalPage);
        System.out.println("起始:" + start + ",结束:" + end + ",当前页:" + page + ",总页数:" + totalPage + ",总数据:" + totalRecord);
        return pageInfo;
    }
}
