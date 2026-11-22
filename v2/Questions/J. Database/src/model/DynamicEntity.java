package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class DynamicEntity {
    private String id;
    private Map<String, Object> map;

    public DynamicEntity() {
        this.id = UUID.randomUUID().toString();
        this.map = new HashMap<>();
    }

    public void save(String key, Object value) {
        this.map.put(key, value);
    }

    public Object get(String key) {
        return this.map.get(key);
    }

    public <T> T getField(String key, Class<T> type) {
        return type.cast(map.get(key));
    }
}
