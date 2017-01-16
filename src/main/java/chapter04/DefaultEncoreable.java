package chapter04;

import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 29/12/2016 14:05
 */
@Component
public class DefaultEncoreable implements Encoreable
{
    @Override
    public void performEncore() {
        System.out.println("返场实现类");
    }
}
