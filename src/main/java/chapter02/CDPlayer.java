package chapter02;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 26/12/2016 19:16
 */
@Component
public class CDPlayer
{
    CompactDisc cd;

    public CDPlayer(CompactDisc cd)
    {
        this.cd = cd;
    }

}

