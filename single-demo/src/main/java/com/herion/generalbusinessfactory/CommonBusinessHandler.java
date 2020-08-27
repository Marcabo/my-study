package com.herion.generalbusinessfactory;

/**
 * 通用业务处理器
 *
 * @auther wubo25320
 * @create 2020-08-27 19:25
 */
public interface CommonBusinessHandler<T,S> extends Comparable<CommonBusinessHandler> {

    /**
     * 业务处理器优先级
     * @return
     */
    Integer order();

    /**
     * 业务处理
     * @param request 请求参数
     * @return S 响应参数
     */
    S execute(T request);
}
