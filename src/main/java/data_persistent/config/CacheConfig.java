package data_persistent.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 缓存配置
 * @author NikoBelic
 * @create 24/01/2017 15:47
 */
@EnableCaching
@Configuration
public class CacheConfig
{

    @Value(value = "${host}")
    private String host;
    @Value(value = "${port}")
    private Integer port;
    @Value(value = "${keynum}")
    private Integer keynum;

    /**
     * 注入CacheManager
     * @Author NikoBelic
     * @Date 24/01/2017 16:05
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate)
    {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(10);
        return cacheManager;
    }

    /**
     * 注入JedisConnectionFactory
     * @Author NikoBelic
     * @Date 24/01/2017 16:03
     */
    @Bean
    public JedisConnectionFactory redisConnectionFactory()
    {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setDatabase(keynum);
        //factory.afterPropertiesSet();
        return factory;
    }

    /**
     * 注入RedisTemplate
     * @Author NikoBelic
     * @Date 24/01/2017 16:02
     */
    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisCF)
    {
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisCF);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    // *********************** Jedis 配置 ***************************

    // 以下配置与缓存无关,在本例中可有可无
    @Bean
    public JedisPoolConfig jedisPoolConfig()
    {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(60 * 1000);
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMaxIdle(100);
        return jedisPoolConfig;
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig)
    {
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,999999999);
        return jedisPool;
    }
    @Bean
    public Jedis jedis(JedisPool jedisPool)
    {
        Jedis jedis = jedisPool.getResource();
        jedis.select(keynum);
        return jedis;
    }
}
