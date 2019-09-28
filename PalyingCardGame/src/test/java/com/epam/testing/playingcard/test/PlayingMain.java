package com.epam.testing.playingcard.test;

import java.util.ArrayList;
import java.util.List;

import com.epam.testing.playingcard.Player;
import com.epam.testing.playingcard.PokersSender;

/**
 * Game Entry
 * @author Kevin He
 * @date 2019/09/22
 */
public class PlayingMain {
    
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("小王"));
        players.add(new Player("小张"));
        players.add(new Player("小李"));
        
        PokersSender sender = new PokersSender();
        sender.shuffle();
        Player player = sender.sendCards(players);
        System.out.println(player.getPlayerName() + "胜出.");
    }
}
