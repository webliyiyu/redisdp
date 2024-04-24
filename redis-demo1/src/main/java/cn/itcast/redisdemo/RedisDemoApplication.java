package cn.itcast.redisdemo;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * ClassName: RedisDemoApplication
 * Description:
 * Date: 2023/04/20 PM 2:06:38
 * <p>
 * project: redis-demo1
 * package: cn.itcast.redisdemo
 * email: 1085844536@qq.com
 * version:
 *
 * @author WangGuojian
 */
@SpringBootApplication
public class RedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

    @Bean
    public LettuceClientConfigurationBuilderCustomizer clientConfigurationBuilderCustomizer() {
        return clientConfigurationBuilder -> {
            clientConfigurationBuilder.readFrom(ReadFrom.REPLICA_PREFERRED);
        };
    }

}
