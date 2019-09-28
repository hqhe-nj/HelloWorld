package com.epam.testing.playingcard;

/**
  *  扑克
 * @author Kevin He
 * @date 2019/09/22
 */
public abstract class BasePokerCard implements Runnable, IJokerCard {
    
    /** 洗牌后的牌组 **/
    private ShuffledDeck shuffledDeck;
    
    /**
     **  竞争进入牌组
     */
    @Override
    public void run() {
        //进入牌组
        shuffledDeck.addCard(this);
    }

    public void setShuffledDeck(ShuffledDeck shuffledDeck) {
        this.shuffledDeck = shuffledDeck;
    }
    
}
