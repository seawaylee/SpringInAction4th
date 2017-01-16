package chapter04;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;

/**
 * @author NikoBelic
 * @create 29/12/2016 12:13
 */
@Aspect
public class PlayCounter
{
    private HashMap<Integer,Integer> trackCounts = new HashMap<>();

    @Pointcut("execution(* *.play(int)) " + "&& args(songNum)")
    public void trackPlayed(int songNum){}

    @Before("trackPlayed(songNum)")
    public void countSong(int songNum)
    {
        int currentCount = getPlayCount(songNum);
        trackCounts.put(songNum,currentCount + 1);
        System.out.println("该歌曲播放过" + currentCount + "次");
    }

    public int getPlayCount(int songNum)
    {
        return trackCounts.containsKey(songNum)?trackCounts.get(songNum):0;
    }
}
