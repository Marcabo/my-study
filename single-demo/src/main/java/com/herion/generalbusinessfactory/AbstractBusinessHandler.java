package com.herion.generalbusinessfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

/**
 * 通用业务基础处理类
 *
 * @auther wubo25320
 * @create 2020-08-27 19:27
 */
public abstract class AbstractBusinessHandler<T,S> implements CommonBusinessHandler<T,S>, ApplicationContextAware, InitializingBean {

    Logger log = LoggerFactory.getLogger(AbstractBusinessHandler.class);

    protected ApplicationContext applicationContext;

    /**
     * 业务类型
     * @return
     */
    protected abstract List<BusinessType> businessTypes();

    @Override
    public Integer order() {
        return 0;
    }

    /**
     * 业务处理器
     * @param request 请求参数
     * @return S 响应参数
     */
    @Override
    public abstract S execute(T request);

    @Override
    public int compareTo(CommonBusinessHandler o) {
        return order().compareTo(o.order());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        businessTypes().forEach(type -> init(type));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void init(BusinessType type) {
        CommonBusinessHandler proxyObj = applicationContext.getBean(this.getClass());
        CommonBusinessFactory.register(type, proxyObj);
        log.info("工厂类型:{}, 处理器类型:{}, SPRING 代理类型:{}, 处理器类名称:{}, 载入通用业务工厂完成...", type.getFactoryType(), type.getHandlerType(), AopUtils.isAopProxy(proxyObj),
                proxyObj.getClass().getName());
    }
}
