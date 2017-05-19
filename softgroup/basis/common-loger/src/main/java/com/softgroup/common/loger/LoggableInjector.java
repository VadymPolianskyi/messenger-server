package com.softgroup.common.loger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * Author: vadym_polyanski
 * Date: 19.05.17
 * Time: 12:58
 */
@Component
public class LoggableInjector implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), field -> {
            ReflectionUtils.makeAccessible(field);
            if (field.getAnnotation(Loggable.class) != null) {
                Logger logger = LoggerFactory.getLogger(bean.getClass());
                field.set(bean,logger);
            }
        });
        return bean;
    }
}
