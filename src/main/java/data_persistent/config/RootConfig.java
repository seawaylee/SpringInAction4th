package data_persistent.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * Spring上下文配置类
 * 由ContextLoaderListener加载的bean
 * @author NikoBelic
 * @create 09/01/2017 20:30
 */
@ComponentScan(basePackages = "data_persistent",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
@Configuration
@EnableMongoRepositories("data_persistent.mongodao") // 开启SpringData自动生成MongoRepository功能
public class RootConfig
{
    public RootConfig()
    {
        System.out.println("RootConfig初始化");
    }

    /**
     * 注入Mysql数据源
     * @Author NikoBelic
     * @Date 23/01/2017 11:31
     */
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

    /**
     * 注入JdbcTemplate
     * @Author NikoBelic
     * @Date 23/01/2017 11:30
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 注入MongoFactory
     * @Author NikoBelic
     * @Date 23/01/2017 11:30
     */
    @Bean
    public MongoFactoryBean mongo()
    {
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.setHost("localhost");
        return mongo;
    }
    /**
     * 注入MongoTempldate
     * MongoOperations是一个借口,MongoTemplate实现了它
     * @Author NikoBelic
     * @Date 23/01/2017 11:30
     */
    @Bean
    public MongoOperations  mongoTemplate(Mongo mongo)
    {
        return new MongoTemplate(mongo,"spring_in_action");
    }
}
