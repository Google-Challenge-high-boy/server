package com.highboy.server.service;

import com.google.gson.Gson;
import com.highboy.server.controller.komantle.dto.KomantleAnswerResponseDto;
import com.highboy.server.controller.komantle.dto.KomantleRequestDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Map;

@Service
@Transactional
public class KomantleService {

    private final RedisTemplate<String, String> redisTemplate;

    public KomantleService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String setRedisKey(Map<String, String> data){
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        try {
            // Redis Set Key-value
            vop.set(data.get("key").toString(), data.get("value").toString());
            return "set message success";
        } catch (Exception e) {
            return "set message fail";
        }
    }

    public Map<String, Object> getAllAnswer(){
        Gson gson = new Gson();
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        String answer = vop.get("relativeItems");
        return gson.fromJson(answer, Map.class);
    }

    public KomantleAnswerResponseDto checkAnswer(KomantleRequestDto komantleRequestDto){
        Gson gson = new Gson();
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        String answer = vop.get("keyword");
        Map<String,Object> answerList = gson.fromJson(vop.get("relativeItems"), Map.class);
        if(answer == komantleRequestDto.getAnswer()){
            return new KomantleAnswerResponseDto(100,answerList);
        }
        try{
            return new KomantleAnswerResponseDto((double) answerList.get(komantleRequestDto.getAnswer()),Collections.emptyMap());
        }
        catch (NullPointerException e){
            return new KomantleAnswerResponseDto(200.0, Collections.emptyMap());
        }

    }


}
