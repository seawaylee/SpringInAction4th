package data_persistent.dao;

import data_persistent.model.UserObj;

/**
 * @author NikoBelic
 * @create 22/01/2017 15:59
 */
public interface UserDao
{
    void addUser();
    UserObj findUserById(Integer id);
}
