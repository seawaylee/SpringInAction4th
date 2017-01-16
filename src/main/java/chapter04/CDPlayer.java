package chapter04;

import org.springframework.stereotype.Component;

/**
 * @author NikoBelic
 * @create 29/12/2016 12:12
*/
@Component
public class CDPlayer
{
    public void play(int songNum)
    {
        System.out.println("正在播放CD磁盘中第" + songNum + "首歌曲\n");
    }
}
