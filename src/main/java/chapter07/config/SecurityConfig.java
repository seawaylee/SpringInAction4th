package chapter07.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置Web安全的细节
 *
 * @author NikoBelic
 * @create 11/01/2017 15:32
 */
//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 对全部web请求进行安全校验
        //http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();

        // 按照URL路径设置安全校验
        http.csrf().disable().formLogin()
                .loginPage("/weibo/showLogin")// 登陆表单
                .and()
                .logout() // 注销  清楚remember-me的token
                .logoutSuccessUrl("/weibo/register")
                .and()
                .httpBasic()//启动服务器认证功能
                .and()
                .rememberMe() // 启动记住我功能
                .tokenValiditySeconds(10) // 只保存10s的token
                .key("weiboKey")
                .and()
                .authorizeRequests()// 授权通过以后
                .antMatchers("/weibo/profile/*").hasRole("USER") // 访问指定路径必须拥有USER角色权限
                .antMatchers(HttpMethod.GET,"/weibo/testSecurity").authenticated() // 指定url只允许GET请求
                .anyRequest().permitAll(); //其他请求均可通过
                //.and()
                //.requiresChannel()
                //.anyRequest().requiresSecure();

        // 使用SpEL表达式进行安全校验
        //http.authorizeRequests()
        //        .antMatchers("/weibo/profile/**")
        //        .authenticated().and().formLogin().and().authorizeRequests().anyRequest()
        //        .access("hasRole('ROLE_USER') and hasIpAddress('192.168.1.1') ");

    }

    /**
     * 用户登陆权限配置
     *
     * @Author NikoBelic
     * @Date 11/01/2017 17:43
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 基于内存的用户权限配置
        //auth.inMemoryAuthentication().withUser("lxw").password("lxw").roles("USER").and()
        //        .withUser("admin").password("admin").roles("USER","ADMIN");

        // 基于JDBC的用户权限配置
        auth.jdbcAuthentication().dataSource(dataSource).
                usersByUsernameQuery("select username,password,true from tb_user where username = ?").
                authoritiesByUsernameQuery("select username,role from tb_user where username = ?").
                passwordEncoder(new MyPasswordDecoder("_salt"));

        // 基于自定义的用户权限配置
        //auth.userDetailsService(new MyUserService());
    }}

/**
 * 密码解码器
 * @Author NikoBelic
 * @Date 11/01/2017 19:26
 */
class MyPasswordDecoder implements PasswordEncoder
{
    private String salt;

    public MyPasswordDecoder(String salt)
    {
        this.salt = salt;
    }

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString() + salt;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodePassword)
    {
        return (rawPassword + salt).equals(encodePassword);
    }
}

/**
 * 自定义用户权限查询类
 * 可以配置为MongoDB、Redis等等
 * @Author NikoBelic
 * @Date 11/01/2017 19:38
 */
class MyUserService implements UserDetailsService
{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        if (username.equals("test"))
        {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            return new User("test", "test",authorities );
        }
        throw new UsernameNotFoundException("没有查询到该用户");
    }
}