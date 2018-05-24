package com.hhq.test.annotation.customannotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import com.hhq.test.annotation.controller.VerifyController;

/**
 * @author Kevin He
 * @date 2018/05/16
 * @version 1.0.0
 */
@Component
public class VerifyAnnotationProcessor implements BeanPostProcessor {

    private VerifyController controller;

    @Autowired
    public VerifyAnnotationProcessor(VerifyController controller) {
        this.controller = controller;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object,
     *      java.lang.String)
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        scanVerifyAnnotation(bean, beanName);
        return bean;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object,
     *      java.lang.String)
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * 
     * @param bean
     * @param beanName
     */
    protected void scanVerifyAnnotation(Object bean, String beanName) {
        configureFieldInjection(bean);
    }

    /**
     * 
     * @param bean
     */
    private void configureFieldInjection(Object bean) {
        Class<?> clazz = bean.getClass();
        VerifyService vefifyService = AnnotationUtils.findAnnotation(clazz, VerifyService.class);
        if (vefifyService != null) {
            controller.registerVefifyServiceBean(vefifyService.verifyType(), bean);
        }
    }

}
