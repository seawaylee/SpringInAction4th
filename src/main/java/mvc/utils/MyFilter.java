package mvc.utils;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author NikoBelic
 * @create 2017/4/11 18:40
 */
@Component(value = "myFilter")
public class MyFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器 - init ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器 - doFilter ");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器 - destroy ");
    }
}
