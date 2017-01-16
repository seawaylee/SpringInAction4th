package chapter03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 27/12/2016 14:46
 */
@Component
public class MagicBeanFactory
{
    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean()
    {
        return new MagicBean();
    }
}

class MagicBean
{
    public MagicBean()
    {
        System.out.println("MagicBean 被初始化了...");
    }
}

class MagicExistsCondition implements Condition
{
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata)
    {
        Environment env = conditionContext.getEnvironment();
        return env.containsProperty("magic");
    }
}