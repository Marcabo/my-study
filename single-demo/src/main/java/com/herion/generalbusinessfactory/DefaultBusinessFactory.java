package com.herion.generalbusinessfactory;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.logging.Handler;

/**
 * 默认业务工厂
 *
 * @auther wubo25320
 * @create 2020-08-27 19:47
 */
public class DefaultBusinessFactory implements BusinessFactory<BusinessType, CommonBusinessHandler> {

    private final Map<Object, Set<CommonBusinessHandler>> handlerMap = new HashMap<>();

    @Override
    public void doRegister(BusinessType type, CommonBusinessHandler handler) {
        Set<CommonBusinessHandler> handlerSet = handlerMap.getOrDefault(type.getHandlerType(), new TreeSet<>());
        handlerSet.add(handler);
        handlerMap.put(type.getHandlerType(),handlerSet);
    }

    @Override
    public <P, S> List<S> doExecute(BusinessType type, P parm) {
        Set<CommonBusinessHandler> handlerSet = handlerMap.get(type.getHandlerType());
        if (CollectionUtils.isEmpty(handlerSet)) {
            throw new RuntimeException(String.format("factory:%s has no handler type:%s", type.getFactoryType(), type.getHandlerType()));
        }
        List<S> list = new LinkedList<>();
        handlerSet.forEach(handler -> list.add((S) handler.execute(parm)));
        return list;
    }

    @Override
    public int size(BusinessType type) {
        return handlerMap.getOrDefault(type.getHandlerType(), new TreeSet<>()).size();
    }
}
