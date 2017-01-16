package chapter04;

import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 28/12/2016 19:02
 */
@Component
public class Performance implements Encoreable
{
    /**
     * 执行该方法的切点表达是语言 execution(* chapter04.Performace.peforne(...))
     * execution:表示执行该表达式语言
     * * 表示任意返回类型
     * chapter04.Performance.performe 分别是 包名、类名、方法名
     * ...表示使用任意参数
     * @Author NikoBelic
     * @Date 28/12/2016 19:04
     */
    public void perform()
    {
        System.out.println("我表演啦");
        //return;
    }

    @Override
    public void performEncore()
    {
        System.out.println("重新表演吧");
    }
}
