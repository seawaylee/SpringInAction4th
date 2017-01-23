package data_persistent.dao;

import data_persistent.model.UserObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * @author NikoBelic
 * @create 22/01/2017 16:01
 */
@Repository
public class UserDaoImpl implements UserDao
{
    @Autowired
    private JdbcOperations jdbcOperations;

    /**
     * 使用JDBCTemplate添加数据
     * @Author NikoBelic
     * @Date 22/01/2017 16:25
     */
    public void addUser()
    {
        UserObj user = new UserObj();
        user.setUsername("NikoBelic");
        user.setPassword("123456");
        user.setRole("ROLE_UNKNOWN");
        jdbcOperations.update("insert into tb_user(username,password,role) values(?,?,?)",
                user.getUsername(), user.getPassword(), user.getRole());
    }
    public UserObj findUserById(Integer id)
    {
        return jdbcOperations.queryForObject("select * from tb_user t where t.id = ?" ,
                (rs,rowNum) ->{
                    return new UserObj(rs.getInt("id"),rs.getString("username"),rs.getString("password"));
                },id);
    }


}
