package com.epam.testing.playingcard;

import com.epam.testing.playingcard.enums.CommonPokerEnum;
import com.epam.testing.playingcard.enums.SuitsEnum;

/**
  * 普通扑克卡片
 * @author Kevin He
 * @date 2019/09/22
 */
public class CommonCard extends BasePokerCard {
    
    /**
          * 扑克面值
     */
    private CommonPokerEnum pokerCard;
    
    /**
          *  花色
     */
    private SuitsEnum suit;
    
    
    
    public CommonCard(CommonPokerEnum pokerCard, SuitsEnum suit) {
        this.pokerCard = pokerCard;
        this.suit = suit;
    }

    public CommonPokerEnum getPokerCard() {
        return pokerCard;
    }

    public void setPokerCard(CommonPokerEnum pokerCard) {
        this.pokerCard = pokerCard;
    }

    public SuitsEnum getSuit() {
        return suit;
    }

    public void setSuit(SuitsEnum suit) {
        this.suit = suit;
    }

    @Override
    public Integer getCardValue() {
        return pokerCard.getValue();
    }

    @Override
    public String getCardName() {
        return suit.name() + " " + pokerCard.name();
    }

}
