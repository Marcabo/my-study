package xyz.herion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 *
 * @auther wubo25320
 * @create 2020-09-21 11:31
 */
@Aspect
@Component
public class DemoAspects {



    @Pointcut("@annotation(xyz.herion.Thr)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object multiThread(ProceedingJoinPoint jp) {
        System.out.println("dddd");
        return null;
    }
}
