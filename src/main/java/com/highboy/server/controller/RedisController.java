package com.highboy.server.controller;

import java.util.Map;

import com.highboy.server.service.KomantleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/redis")
@RequiredArgsConstructor
public class RedisController {

    private  final KomantleService komantleService;
    private final RedisTemplate<String, String> redisTemplate;

    // set
    @PostMapping("")
    public String setRedisKey(@RequestBody Map<String, String> req){
        return komantleService.setRedisKey(req);
    }

    // get
    @GetMapping("/{key}")
    public String getRedisKey(@PathVariable String key) {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        return vop.get(key);
    }

}