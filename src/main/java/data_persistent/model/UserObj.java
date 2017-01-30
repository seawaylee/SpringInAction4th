package data_persistent.model;

import java.io.Serializable;

/**
 * @author NikoBelic
 * @create 22/01/2017 15:58
 */
public class UserObj implements Serializable
{
    private static final long serialVersionUID = -5220639324096547958L;

    private Integer id;
    private String username;
    private String password;
    private String role;

    public UserObj() {
    }

    public UserObj(int id, String username, String password,String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "UserObj{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
