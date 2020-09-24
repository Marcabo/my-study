package xyz.herion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther wubo25320
 * @create 2020-09-21 13:42
 */
public class TestDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ThreadDemo bean = context.getBean(ThreadDemo.class);
        String s = bean.testThread();
        System.out.println(s);
    }
}
