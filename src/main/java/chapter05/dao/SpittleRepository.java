package chapter05.dao;

import chapter05.model.Spittle;

import java.util.List;

/**
 * @author NikoBelic
 * @create 30/12/2016 14:27
 */
public interface SpittleRepository
{
    List<Spittle> findSpittles(long max, int count);
}
