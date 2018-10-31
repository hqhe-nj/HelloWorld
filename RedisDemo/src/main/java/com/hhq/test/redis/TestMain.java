package com.hhq.test.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.Set;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.BeanSerializer;

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
        JedisPool pool = getPool(PoolResourceEnum.MYVM_REDIS_128);
        Jedis jedis = pool.getResource();
        jedis.select(0);
        /*if (null == jedis.hget("20180606-SEQUENCE", "101401")) {
            jedis.hset("20180606-SEQUENCE", "101401", "2");
        }
        if (null == jedis.hget("20180606-SEQUENCE", "101402")) {
            jedis.hset("20180606-SEQUENCE", "101402", "10");
        }
        
        Long ss = jedis.hincrBy("20180606-SEQUENCE", "101402", 2L);
        System.out.println(ss);
        
        Long qq = jedis.incr("20180601-SEQUENCE");
        System.out.println(qq);*/

        /*testSet(jedis);
        testHset(jedis);
        testHget(jedis);
        testFlushAll(jedis);
        testKeys(jedis);
        testDel(jedis);*/

//        testSet(jedis);
//        System.out.println("================ Jedis has set a lot of keys=====================");
//        testDelKeys(jedis);
        testDel(jedis);
        System.out.println("================== Jedis has deleted all of the keys =======================");
    }

    public static void testSet(Jedis jedis) {
        String keyPrefix = "20181027:0000001:123456";
        for (int i = 0; i < 10000; i++) {
            String key = keyPrefix + i;
            jedis.set(key, String.valueOf(i));
        }

    }

    public static void testKeys(Jedis jedis) {
        Set<String> set = jedis.keys("verify*");
        for (String key : set) {
            System.out.println("key name: " + key);
        }
    }

    public static void testDel(Jedis jedis) {
        Set<String> set = jedis.keys("20181027*");
        System.out.println("======= Delete start time:" + new Date());
        for (String key : set) {
            jedis.del(key);
//            System.out.println("Deleting key: " + key);
        }
        System.out.println("======= Delete end time:" + new Date());

    }

    public static void testDelKeys(Jedis jedis) {
        Set<String> set = jedis.keys("20181027*");
        String [] keysAraay = new String[set.size()];
        set.toArray(keysAraay);
        jedis.del(keysAraay);
    }

    public static void testFlushAll(Jedis jedis) {
        jedis.select(0);
        jedis.flushDB();
    }

    public static void testHget(Jedis jedis) {

        byte[] bytes = jedis.hget("ENT-LICENSE-20180612".getBytes(), "05023820180612001101280002".getBytes());

        Person out = deserializeBean(bytes, Person.class);

        System.out.println("Person [name]: " + out.getName() + " [id]:" + out.getId());
    }

    public static void testHset(Jedis jedis) {
        Person person = new Person();
        person.setId("123");
        person.setName("OKKK");

        byte[] bytes = serializeBean(person, Person.class);
        long len = jedis.hset("ENT-LICENSE-20180612".getBytes(), "05023820180612001101280002".getBytes(), bytes);
        System.out.println("put a obj, which len is: " + len);
    }

    private static <T> byte[] serializeBean(T obj, Class<T> cls) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(512);

        Kryo kryo = new Kryo();
        kryo.setReferences(true);
        kryo.register(cls, new BeanSerializer<T>(kryo, cls));

        Output out = new Output(outputStream);
        try {
            kryo.writeObject(out, obj);
            out.flush();
        } finally {
            out.close();
        }

        return outputStream.toByteArray();
    }

    private static <T> T deserializeBean(byte[] bytes, Class<T> cls) {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        Kryo kryo = new Kryo();
        kryo.setReferences(true);
        kryo.register(cls, new BeanSerializer<T>(kryo, cls));
        Input input = new Input(inputStream);
        try {
            return (T)kryo.readObject(input, cls);
        } finally {
            input.close();
        }
    }

    private static JedisPool getPool(PoolResourceEnum poolResource) {
        JedisPool pool = null;
        switch (poolResource) {
            case LAKALA_REDIS:
                pool = new JedisPool("10.7.111.164", 6379);
                break;
            case MYVM_REDIS_128:
                pool = new JedisPool("192.168.10.128", 6379);
                break;
            case MYVM_REDIS_129:
                pool = new JedisPool("192.168.10.129", 6379);
                break;
            default:

        }
        return pool;
    }

}
