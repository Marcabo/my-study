package com.herion.generalbusinessfactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用业务工厂
 *
 * @auther wubo25320
 * @create 2020-08-27 20:02
 */
public class CommonBusinessFactory implements BusinessFactory<BusinessType, CommonBusinessHandler> {

    private final Map<String, BusinessFactory> factoryMap = new HashMap<>();

    private static final CommonBusinessFactory FACTORY = new CommonBusinessFactory();

    @Override
    public void doRegister(BusinessType type, CommonBusinessHandler handler) {
        BusinessFactory factory = factoryMap.get(type.getFactoryType());
        factory.doRegister(type, handler);
        factoryMap.put(type.getFactoryType(), factory);
    }

    @Override
    public <P, S> List<S> doExecute(BusinessType type, P parm) {
        BusinessFactory factory = factoryMap.get(type.getFactoryType());
        if (factory == null) {
            throw new RuntimeException("factory [" + type.getFactoryType() + "] is not found");
        }
        return factory.doExecute(type, parm);
    }

    @Override
    public int size(BusinessType type) {
        BusinessFactory factory = factoryMap.get(type.getFactoryType());
        return factory == null ? 0 : factory.size(type);
    }

    public static void register(BusinessType type, CommonBusinessHandler handler) {
        FACTORY.doRegister(type,handler);
    }

    public static <P,S> List<S> executeMultiple(BusinessType type, P param) {
        return FACTORY.doExecute(type, param);
    }

    public static <P,S> S executeSingle(BusinessType type, P param) {
        int len = 0;
        if ((len = FACTORY.size(type)) > 1) {
            throw new RuntimeException("factory [\" + type.getFactoryType() + \"] , handler type [\" + type.getHandlerType() + \"] must has one handler, but has [\" + len + \" ]...");
        }
        List<S> list = FACTORY.doExecute(type, param);
        return list.get(list.size() - 1);
    }
}
