package mvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author NikoBelic
 * @create 2017/3/29 21:54
 */
@Controller
@RequestMapping(value = "/mvc")
public class TestController
{

    /**
     * 测试启动
     *
     * @Author SeawayLee
     * @Date 2017/03/29 22:08
     */
    @ResponseBody
    @RequestMapping(value = "/")
    public Object helloMVC(HttpServletRequest request, HttpServletResponse response)
    {
        return "Let's Go";
    }

    /**
     * 测试Content-Type
     *
     * @Author SeawayLee
     * @Date 2017/03/29 22:24
     */
    @ResponseBody
    @RequestMapping(value = "/testContentType", consumes = "text/html;charset=utf-8", produces = "application/json;charset=utf-8", params = {"patientId"}, headers = {"ABC"})
    public Object testContentType(HttpServletRequest request, HttpServletResponse response, String patientId)
    {
        return patientId + "\n" + request.getContentType();
    }

    /**
     * 这种参数接收方式，实质上是UrlParam
     * UrlParam一定会导致中文乱码，除非客户端手动将中文URLEncode
     *
     * @Author SeawayLee
     * @Date 2017/03/29 22:49
     */
    @ResponseBody
    @RequestMapping(value = "/getJson1", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Object getJson1(HttpServletRequest request, HttpServletResponse response, String patientId, String patientName) throws UnsupportedEncodingException
    {
        System.out.println(patientName);
        return new Patient(patientId, patientName);
    }

    /**
     * @ReuqestBody 指明被注解的参数是请求的body，可以是一个json结构，只要双方字符集统一，不会出现中文乱码
     * @Author SeawayLee
     * @Date 2017/03/29 23:14
     */
    @ResponseBody
    @RequestMapping(value = "/getJson2", method = RequestMethod.POST, produces = "application/json")
    public Object getJson2(HttpServletRequest request, @RequestBody JSONObject patientJson) throws UnsupportedEncodingException
    {
        System.out.println(patientJson);
        return patientJson;
    }

    /**
     * 和上面一样
     * @Author SeawayLee
     * @Date 2017/03/29 23:16
     */
    @ResponseBody
    @RequestMapping(value = "/getJson3", method = RequestMethod.POST, produces = "application/json")
    public Object getJson3(HttpServletRequest request, @RequestBody Map<String, String> params) throws UnsupportedEncodingException
    {
        System.out.println(params);
        return params;
    }


    /**
     * 如果请求参数中既有json，又有独立的参数，客户端需要将数据以表单的形式提交
     * @Author SeawayLee
     * @Date 2017/03/29 23:36
     */
    @ResponseBody
    @RequestMapping(value = "/getJson4", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Object getJson4(HttpServletRequest request, @RequestParam(required = true) String patientJson,@RequestParam(required = false) String city) throws UnsupportedEncodingException
    {
        System.out.println(patientJson);
        System.out.println(city);
        return patientJson;
    }

    /**
     * 同上
     * @Author SeawayLee
     * @Date 2017/03/29 23:40
     */
    @ResponseBody
    @RequestMapping(value = "/getJson5", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Object getJson5(HttpServletRequest request) throws UnsupportedEncodingException
    {
        String patientJson = request.getParameter("patientJson");
        String city = request.getParameter("city");
        System.out.println(patientJson);
        System.out.println(city);
        return patientJson;
    }


    class Patient implements Serializable
    {
        private String patientId;

        private String patientName;

        public Patient(String patientId, String patientName) {
            this.patientId = patientId;
            this.patientName = patientName;
        }

        public String getPatientId() {
            return patientId;
        }

        public void setPatientId(String patientId) {
            this.patientId = patientId;
        }

        public String getPatientName() {
            return patientName;
        }

        public void setPatientName(String patientName) {
            this.patientName = patientName;
        }
    }
}
