package com.hhq.test.annotation.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhq.test.annotation.controller.verifyservice.InvokeService;

/**
 * @author Kevin He
 * @date 2018/05/16
 * @version 1.0.0
 */
@Controller
@RequestMapping("/servlet/json")
@ResponseBody
public class VerifyController {
    
    private Map<String, InvokeService> vefifyServiceBeans;
    
    public VerifyController() {
        vefifyServiceBeans = new HashMap<>();
    }
    
    @RequestMapping(path = "{verifyType}", method = RequestMethod.POST)
    public Object doPost(HttpServletRequest request, HttpServletResponse response, @PathVariable String verifyType) {
        if (null != verifyType) {
            InvokeService invoker = vefifyServiceBeans.get(verifyType);
            return invoker.invoke(getInputContext(request));
        } else {
            return null;
        }
    }
    
    public void registerVefifyServiceBean(String beanName, Object bean) {
        if (bean instanceof InvokeService) {
            vefifyServiceBeans.put(beanName, (InvokeService) bean);
        }
    }
    
    private String getInputContext(HttpServletRequest request) {
        try {
            InputStream in = request.getInputStream();
            byte [] bytes = new byte[request.getContentLength()];
            in.read(bytes);
            
        } catch (IOException e) {
        }
        return null;
    }
    
}
