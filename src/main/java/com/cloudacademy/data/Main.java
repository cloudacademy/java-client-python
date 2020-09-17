package com.cloudacademy.data;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
 
import java.util.Set;

public class Main {
    //address of redis server
    private static final String redisHost = "localhost";
    private static final Integer redisPort = 6379;

    //jedis connection pool
    private static JedisPool pool = null;
 
    public Main() {
        //configure jedis pool connection
        pool = new JedisPool(redisHost, redisPort);
    }

    public void demoSets() {
        //get a jedis connection jedis connection pool
        Jedis jedis = pool.getResource();

        //cache set data
        System.out.println("writing...");
        String key = "languages";
        jedis.sadd(key, "Python", "Java", "C#", "Ruby", "NodeJS");

        //retrieve set data
        System.out.println("reading...");
        Set<String> members = jedis.smembers(key);
        for (String member : members) {
            System.out.println(member);
        }
    }

    public static void main(String[] args){
        Main main = new Main();
        main.demoSets();
    }
}