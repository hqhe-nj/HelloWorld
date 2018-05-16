package com.hhq.test.annotation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Kevin He
 * @date 2018/05/16
 * @version 1.0.0
 */
@Controller
@RequestMapping("/servlet/json")
public class VerifyController {
    
    private Map<String, Object> vefifyServiceBeans;
    
    public VerifyController() {
        vefifyServiceBeans = new HashMap<>();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        
    }
    
    public void registerVefifyServiceBean(String beanName, Object bean) {
        vefifyServiceBeans.put(beanName, bean);
    }

}
