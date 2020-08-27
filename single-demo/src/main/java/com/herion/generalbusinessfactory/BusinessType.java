package com.herion.generalbusinessfactory;

import java.util.*;

/**
 * 业务类型
 *
 * @auther wubo25320
 * @create 2020-08-27 19:08
 */
public class BusinessType {

    /**
     * 工厂类型
     */
    private String factoryType;

    /**
     * 处理器类型
     */
    private Object handlerType;

    public static List<BusinessType> builder(String factoryType, Object... handlerType) {
        if (handlerType == null || handlerType.length == 0) {
            return Collections.emptyList();
        }

        List<BusinessType> list = new LinkedList<>();
        Arrays.asList(handlerType).forEach(type -> {
            if (type != null) {
                list.add(new BusinessType(factoryType, type));
            }
        });

        return list;
    }

    public String getFactoryType() {
        return factoryType;
    }

    public void setFactoryType(String factoryType) {
        this.factoryType = factoryType;
    }

    public Object getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(Object handlerType) {
        this.handlerType = handlerType;
    }

    public BusinessType(String factoryType, Object handlerType) {
        this.factoryType = factoryType;
        this.handlerType = handlerType;
    }
}
