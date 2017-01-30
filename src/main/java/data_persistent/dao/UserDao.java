package data_persistent.dao;

import data_persistent.model.UserObj;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author NikoBelic
 * @create 22/01/2017 15:59
 */
public interface UserDao
{
    @CachePut(value = "UserCaching",key = "#result.id")
    UserObj addUser(UserObj userObj);

    @Cacheable("UserCaching")
    UserObj findUserById(Integer id);

    void updateUserById(Integer id,UserObj userObj);

    @CacheEvict("UserCaaching")
    void deleteUserById(Integer id);
}
