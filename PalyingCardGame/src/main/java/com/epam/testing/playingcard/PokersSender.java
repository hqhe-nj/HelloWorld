package com.epam.testing.playingcard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.testing.playingcard.enums.CommonPokerEnum;
import com.epam.testing.playingcard.enums.JokerEnum;
import com.epam.testing.playingcard.enums.SuitsEnum;

/**
  * 发牌人
 * 
 * @author Kevin He
 * @date 2019/09/22
 */
public class PokersSender {

    /** 一盒扑克 **/
    private List<BasePokerCard> cardsDeck;
    
    /** 洗牌后的扑克组 **/
    private ShuffledDeck shuffledDeck;

    public PokersSender() {
        initDeck();
        shuffledDeck = new ShuffledDeck();
    }

    /**
          * 初始化一副牌
     */
    private void initDeck() {
        this.cardsDeck = new ArrayList<>();
        //普通牌
        for (CommonPokerEnum pokerEnum : CommonPokerEnum.values()) {
            cardsDeck.add(new CommonCard(pokerEnum, SuitsEnum.CLUB));
            cardsDeck.add(new CommonCard(pokerEnum, SuitsEnum.DIAMOND));
            cardsDeck.add(new CommonCard(pokerEnum, SuitsEnum.HEART));
            cardsDeck.add(new CommonCard(pokerEnum, SuitsEnum.SPADE));
        }
        //大小王
        cardsDeck.add(new JokerCard(JokerEnum.BLACK_JOKER));
        cardsDeck.add(new JokerCard(JokerEnum.RED_JOKER));
    }
    
    /**
          *  模拟洗牌动作,在同一时刻将牌塞入扑克牌组<p>
          *  等待发牌
     */
    public void shuffle() {
        final ExecutorService cardPool = Executors.newFixedThreadPool(cardsDeck.size());
        //54张牌竞争进牌组
        for (BasePokerCard card : cardsDeck) {
            card.setShuffledDeck(shuffledDeck);
            cardPool.execute(card);
        }
        
        cardPool.shutdown();
        
    }
    
    /**
           * 发牌
     * @param players
     * @return
     */
    public Player sendCards(List<Player> players) {
        List<BasePokerCard> cardDeck = shuffledDeck.getShuffledDeck();
        //one round = i + 3
        for (int i = 0; i < cardDeck.size();) {
            System.out.println("这是第" + (i / players.size() + 1) + "轮发牌...");
            for (Player player : players) {
                player.recieveCard(cardDeck.get(i));
                int points = player.figureOutPoints();
                if (points >= 50) {
                    return player;
                }
                i++;
            }
        }
        return null;
    }

}
