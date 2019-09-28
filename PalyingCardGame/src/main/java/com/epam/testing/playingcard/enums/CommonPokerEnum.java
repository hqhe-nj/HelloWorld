package com.epam.testing.playingcard.enums;

/**
 * 普通扑克牌枚举
 * @author Kevin He
 * @date 2019/09/22
 */
public enum CommonPokerEnum {
    /** A尖 **/
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    /** J **/
    JACK(11),
    /** Q **/
    QUEEN(12),
    /** K **/
    KING(13);
    
    private Integer value;
    
    CommonPokerEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
}
