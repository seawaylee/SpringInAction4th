package chapter05.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author NikoBelic
 * @create 02/01/2017 00:05
 */
public class Spitter
{
    @NotNull
    @Size(min = 5, max = 16)
    String username;
    @NotNull
    @Size(min = 2, max = 5)
    String firstName;
    @NotNull
    @Size(min = 2, max = 5)
    String lastName;
    @NotNull
    @Size(min = 8)
    String password;

    public Spitter() {
    }

    public Spitter(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
