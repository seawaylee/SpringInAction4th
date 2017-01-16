package chapter03;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 27/12/2016 15:42
 */
@Component
//@Qualifier("cat")
@Primary
public class Cat implements Animal
{
}
