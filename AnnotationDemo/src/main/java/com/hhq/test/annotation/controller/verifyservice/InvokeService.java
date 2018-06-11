package com.hhq.test.annotation.controller.verifyservice;

/**
 * @author Kevin He
 * @date 2018/05/24
 * @version 1.0.0
 */
public interface InvokeService {

    /**
     * Invoke the remote service
     * 
     * @param requestBody
     * @return
     */
    public Object invoke(String requestBody);
}
