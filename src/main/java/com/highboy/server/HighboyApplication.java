package com.highboy.server;

import com.fasterxml.jackson.databind.JsonNode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class HighboyApplication {
    private final RedisTemplate<String, String> redisTemplate;


    public HighboyApplication(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;

    }

    @Scheduled(cron = "0 1 0 * * *")
    public void run() throws ParseException {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        JSONParser parser = new JSONParser();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<JsonNode> entity = restTemplate.getForEntity("http://202.30.30.3:4207/api/komantle", JsonNode.class);

        JSONObject object = (JSONObject) parser.parse(String.valueOf(entity.getBody()));

        vop.set("keyword",object.get("keyword").toString());
        vop.set("relativeItems",object.get("relativeItems").toString());
    }
    public static void main(String[] args) {
        SpringApplication.run(HighboyApplication.class, args);
    }

}
