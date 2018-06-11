package com.hhq.test.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Kevin He
 * @date 2018/06/07
 * @version 1.0.0
 */
public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JedisPool pool = new JedisPool("192.168.10.128", 6379);
        Jedis jedis = pool.getResource();
        
        if (null == jedis.hget("20180606-SEQUENCE", "101401")) {
            jedis.hset("20180606-SEQUENCE", "101401", "2");
        }
        if (null == jedis.hget("20180606-SEQUENCE", "101402")) {
            jedis.hset("20180606-SEQUENCE", "101402", "10");
        }
        
        Long ss = jedis.hincrBy("20180606-SEQUENCE", "101402", 2L);
        System.out.println(ss);
        
        Long qq = jedis.incr("20180601-SEQUENCE");
        System.out.println(qq);
    
    }

}
