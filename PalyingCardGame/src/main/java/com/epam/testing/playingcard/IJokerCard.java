package com.epam.testing.playingcard;

/**
 * @author Kevin He
 * @date 2019/09/22
 */
public interface IJokerCard {
    
    /**
          * 获取牌面值
     * @return
     */
    Integer getCardValue();
    
    /**
          * 获取牌面名称
     * @return
     */
    String getCardName();
}
