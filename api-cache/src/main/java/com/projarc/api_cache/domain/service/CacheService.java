package com.projarc.api_cache.domain.service;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("servcad/assinaturas")
public class CacheService {
    private static final HashMap<Integer, Boolean> MAPPER = new HashMap<>();

    @GetMapping("assinvalida/{param}")
    public String getMethodName(@PathVariable int param) {
        return "Hello, " + param;
    }

    public static void add(int id, boolean value) {
        MAPPER.put(id, value);
    }

    public static boolean get(int id) {
        return MAPPER.get(id);
    }
}
