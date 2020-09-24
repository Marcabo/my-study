package xyz.herion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @auther wubo25320
 * @create 2020-09-21 13:47
 */
@Configuration
@ComponentScan(basePackages = {"xyz.herion"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
