package chapter01;

/**
 * @author NikoBelic
 * @create 23/12/2016 18:10
 */
public class CommonUtils
{
    public static void beforeInsert()
    {
        System.out.println("我是公共方法,我要在所有的插入操作前调用...");
    }
    public static void afterInsert()
    {
        System.out.println("我是公共方法,我要在所有的插入操作后调用...");
    }
}
