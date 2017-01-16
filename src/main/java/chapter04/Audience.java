package chapter04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 28/12/2016 19:38
 */
//@Aspect
@Component
public class Audience
{
    // 定义命名的切点
    //@Pointcut("execution(* *.perform(..))")
    //public void performance()
    //{}

    //@Around(("performance()"))
    public void watchPerformance(ProceedingJoinPoint joinPoint)
    {
        try
        {
            System.out.println("环绕-手机静音");
            System.out.println("环绕-就坐");
            joinPoint.proceed();
            System.out.println("环绕-牛b牛b!再来一个!");

        } catch (Throwable throwable)
        {
            System.out.println("环绕-垃圾!退钱!");
        }
    }


    //@Before("performance()")
    public void silenceCellPhones()
    {
        System.out.println("观众们请关闭手机铃声...");
    }

    //@Before("performance()")
    public void takSeats()
    {
        System.out.println("大家请坐...");
    }

    //@AfterReturning("performance()")
    public void applause()
    {
        System.out.println("大家请鼓掌...");
    }

    //@AfterThrowing("performance()")
    public void deamanRefund()
    {
        System.out.println("表演失败了,大家鼓励一下...");
    }
}
