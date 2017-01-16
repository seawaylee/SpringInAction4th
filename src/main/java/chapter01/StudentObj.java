package chapter01;

/**
 * @author NikoBelic
 * @create 23/12/2016 16:55
 */
public class StudentObj
{
    private Object arm;


    public StudentObj()
    {
        this.arm = new SmallArm(); // 写死了手臂类型,对象之间紧密耦合
    }

    public StudentObj(Object arm)
    {
        this.arm = arm;
    }

    public void insertA()
    {
        System.out.println("我是Student.insertA()");
    }
    public void insertB()
    {
        System.out.println("我是Student.insertB()");
    }
    public void selectA()
    {
        System.out.println("我是Student.selectA()");
    }
    public void show()
    {
        System.out.println("我是一个小浪仔..");
    }
}

