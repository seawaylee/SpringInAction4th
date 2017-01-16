package chapter01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author NikoBelic
 * @create 23/12/2016 17:00
 */
public class Main
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        StudentObj student = ctx.getBean(StudentObj.class);
        student.insertA();
        student.insertB();

    }
}
