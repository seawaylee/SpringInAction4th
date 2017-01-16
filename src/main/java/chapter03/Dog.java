package chapter03;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 27/12/2016 15:41
 */
@Component
//@Qualifier("dog")
//@Primary
public class Dog implements Animal
{
}
