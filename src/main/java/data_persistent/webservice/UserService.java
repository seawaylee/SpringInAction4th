package data_persistent.webservice;

import data_persistent.model.UserObj;

/**
 * Created by NikoBelic on 30/01/2017.
 */
public interface UserService
{
    public UserObj addUser(UserObj userObj);

    public UserObj findUserById(Integer id);

    public void updateUserById(Integer id, UserObj userObj);

    public void deleteUserById(Integer id);
}
