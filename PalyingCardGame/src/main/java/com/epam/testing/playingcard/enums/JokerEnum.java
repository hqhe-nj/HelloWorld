package com.epam.testing.playingcard.enums;

/**
 * Joker 枚举
 * @author Kevin He
 * @date 2019/09/22
 */
public enum JokerEnum {
    /** 小王 **/
    RED_JOKER(20),
    /** 大王 **/
    BLACK_JOKER(20);
    
    private Integer value;
    
    JokerEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
