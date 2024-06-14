package com.localtrends.userservice.repository;

import com.localtrends.userservice.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RedisUserRepositoryImpl implements RedisUserRepository {

    private static final String KEY = "User";
    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOperations;

    public RedisUserRepositoryImpl(RedisTemplate<String, User> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put(KEY, user.getId(), user);

    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public User findById(Long id) {
        return (User) hashOperations.get(KEY, id);
    }

    @Override
    public void update(User user) {
        hashOperations.put(KEY, user.getId(), user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
}
