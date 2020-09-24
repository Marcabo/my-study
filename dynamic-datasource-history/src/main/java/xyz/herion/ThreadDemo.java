package xyz.herion;

import org.springframework.stereotype.Component;

/**
 * 线程测试
 *
 * @auther wubo25320
 * @create 2020-09-21 11:29
 */
@Component
public class ThreadDemo {

    @Thr
    public String testThread() {
        String result = "当前线程: " + Thread.currentThread().getName();
        System.out.println(result);

        return result;
    }
}
