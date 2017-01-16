package chapter05.dao;

import chapter05.model.Spitter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NikoBelic
 * @create 02/01/2017 00:05
 */
@Repository
public class SpitterDao
{
    private List<Spitter> spitterList;

    public SpitterDao()
    {
        this.spitterList = new ArrayList<>();
        System.out.println(spitterList);
    }

    public void save(Spitter spitter)
    {
        spitterList.add(spitter);
    }

    public Spitter findSpitterByUsername(String username)
    {
        for (Spitter spitter : spitterList)
        {
            if (spitter.getUsername().equals(username))
                return spitter;
        }
        return null;
    }
}
