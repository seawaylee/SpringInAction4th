package chapter04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author NikoBelic
 * @create 28/12/2016 19:53
 */
@Configuration
@EnableAspectJAutoProxy/*启动AspectJ自动代理*/
@ComponentScan
public class ConcertConfig
{
    // 声明Audience bean
    @Bean
    public Audience audience()
    {
        return new Audience();
    }

    @Bean
    public PlayCounter playCounter()
    {
        return new PlayCounter();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer()
    {
        return new EncoreableIntroducer();
    }
}
