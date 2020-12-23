package com.muhuan.algorithm.debug.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

/**
 * @Author: yg
 * @Date: 2020/12/21 13:45
 * @description ...
 * TODO:
 */
@Service
public class GoodsService {
    private RedissonClient redisson;
    public void d(){
        RLock rLock = redisson.getLock("asd");
    }
}
