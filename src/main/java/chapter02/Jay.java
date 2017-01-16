package chapter02;

import org.springframework.stereotype.Component;
import sun.jvm.hotspot.tools.SysPropsDumper;

/**
 * @author NikoBelic
 * @create 26/12/2016 14:05
 */
@Component
public class Jay implements CompactDisc
{
    private String title = "七里香";
    private String artist = "周杰伦";

    public void play()
    {
        System.out.println("播放器正在播放 " + title + "-" + artist);
    }
}
