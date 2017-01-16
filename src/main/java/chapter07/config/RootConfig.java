package chapter07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * Spring上下文配置类
 * 由ContextLoaderListener加载的bean
 * @author NikoBelic
 * @create 09/01/2017 20:30
 */
@Configuration
@ComponentScan(basePackages = "chapter07",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig
{

    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/dmes?characterEncoding=UTF-8");
        ds.setUsername("root");
        ds.setPassword("lxw1993822");
        return ds;
    }
}
