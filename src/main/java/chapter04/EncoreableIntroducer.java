package chapter04;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author NikoBelic
 * @create 29/12/2016 14:03
 */
@Aspect
public class EncoreableIntroducer
{
    @DeclareParents(value = "chapter04.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
