package com.herion.generalbusinessfactory;

import java.util.List;

/**
 * 业务工厂接口
 *
 * @auther wubo25320
 * @create 2020-08-27 19:38
 */
public interface BusinessFactory<T,H> {

    /**
     * 注册处理器
     * @param type
     * @param handler
     */
    void doRegister(T type, H handler);

    /**
     * 执行业务
     * @param type 类型
     * @param parm 参数
     * @param <P>
     * @param <S>
     * @return
     */
    <P,S> List<S> doExecute(T type, P parm);

    /**
     * 处理器个数
     * @param type
     * @return
     */
    int size(T type);
}
