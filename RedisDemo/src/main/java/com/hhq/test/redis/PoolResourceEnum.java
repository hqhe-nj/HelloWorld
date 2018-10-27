 package com.hhq.test.redis;

 /**
 * @author Kevin He
 * @date 2018/06/12
 * @version 1.0.0
 */
public enum PoolResourceEnum {
    
    LAKALA_REDIS(1),
    MYVM_REDIS_128(2),
    MYVM_REDIS_129(3)
    ;
    
    private int code;
    
    PoolResourceEnum(int code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
    
    
}
