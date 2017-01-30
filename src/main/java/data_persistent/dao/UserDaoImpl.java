package data_persistent.dao;

import data_persistent.model.UserObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
     *
     * @Author NikoBelic
     * @Date 22/01/2017 16:25
     */
    public UserObj addUser(UserObj user)
    {
        KeyHolder holder = new GeneratedKeyHolder();
        int id = jdbcOperations.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into tb_user(username,password,role) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            return ps;
        }, holder);
        user.setId(holder.getKey().intValue());
        return user;
    }

    public UserObj findUserById(Integer id)
    {
        System.out.println("findUserById si called...");
        return jdbcOperations.queryForObject("select * from tb_user t where t.id = ?",
                (rs, rowNum) -> {
                    return new UserObj(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("role"));
                }, id);
    }

    public void updateUserById(Integer id, UserObj userObj)
    {
        jdbcOperations.update("update tb_user t set t.username = ? ,t.password = ?,t.role = ? where t.id = ?",
                userObj.getUsername(), userObj.getPassword(), userObj.getRole(), id);
    }

    @Override
    public void deleteUserById(Integer id)
    {
        //jdbcOperations.update("delete from tb_user where id = ?",id);
        System.out.println("删除数据库中的用户" + id);
    }

}
