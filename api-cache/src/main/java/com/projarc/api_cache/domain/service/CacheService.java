package com.projarc.api_cache.domain.service;

import java.util.HashMap;

public class CacheService {
    private static final HashMap<Integer, Boolean> MAPPER = new HashMap<>();

    public static void add(int id, boolean value) {
        MAPPER.put(id, value);
    }

    public static boolean get(int id) {
        return MAPPER.get(id);
    }
}
