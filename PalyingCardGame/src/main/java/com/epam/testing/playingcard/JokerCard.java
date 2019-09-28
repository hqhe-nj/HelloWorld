package com.epam.testing.playingcard;

import com.epam.testing.playingcard.enums.JokerEnum;

/**
  * 大小王扑克卡片
 * @author Kevin He
 * @date 2019/09/22
 */
public class JokerCard extends BasePokerCard {
    
    public JokerCard(JokerEnum joker) {
        this.jokerCard = joker;
    }
    
    /** 大小王面值 **/
    private JokerEnum jokerCard;

    public JokerEnum getJokerCard() {
        return jokerCard;
    }

    public void setJokerCard(JokerEnum jokerCard) {
        this.jokerCard = jokerCard;
    }

    @Override
    public Integer getCardValue() {
         return jokerCard.getValue();
    }

    @Override
    public String getCardName() {
        return jokerCard.name();
    }

}
