package data_persistent.webservice;

import data_persistent.dao.UserDao;
import data_persistent.model.UserObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author NikoBelic
 * @create 25/01/2017 22:44
 */
@Component
@WebService(serviceName = "userService")
public class UserWebService
{
    @Autowired
    private UserDao userDao;

    //@WebMethod
    public UserObj addUser(UserObj userObj)
    {
        return userDao.addUser(userObj);
    }
    //@WebMethod
    public UserObj findUserById(Integer id)
    {
        return userDao.findUserById(id);
    }
    //@WebMethod
    public void updateUserById(Integer id, UserObj userObj)
    {
        userDao.updateUserById(id, userObj);
    }
    //@WebMethod
    public void deleteUserById(Integer id)
    {
        userDao.deleteUserById(id);
    }
}
