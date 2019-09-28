package com.epam.testing.playingcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin He
 * @date 2019/09/22
 */
public class ShuffledDeck {
    
    /** 洗牌后的扑克组 **/
    private List<BasePokerCard> shuffledDeck;
    
    public ShuffledDeck() {
        shuffledDeck = new ArrayList<>();
    }
    
    /**
          * 添加一张牌
     * @param card
     */
    public synchronized void addCard(BasePokerCard card) {
        shuffledDeck.add(card);
    }

    public List<BasePokerCard> getShuffledDeck() {
        return shuffledDeck;
    }
    
}
