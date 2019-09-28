package com.epam.testing.playingcard;

import java.util.ArrayList;
import java.util.List;

/**
  * 玩家
 * @author Kevin He
 * @date 2019/09/22
 */
public class Player {
    
    /** 玩家姓名 **/
    private String playerName;
    
    /** 手中的牌组 **/
    private List<BasePokerCard> cards;
    
    public Player(String playerName) {
        this.cards = new ArrayList<>();
        this.playerName = playerName;
    }
    
    /**
          * 拿牌
     * @param card
     */
    public void recieveCard(BasePokerCard card) {
        cards.add(card);
    }
    
    /**
          * 算出总点数
     * @return
     */
    public Integer figureOutPoints() {
        Integer sum = 0;
        for (BasePokerCard card : cards) {
            sum += card.getCardValue();
        }
        return sum;
    }

    public String getPlayerName() {
        return playerName;
    }
    
}
