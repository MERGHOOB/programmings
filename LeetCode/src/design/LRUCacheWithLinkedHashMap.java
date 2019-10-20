package design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap extends LinkedHashMap<Integer, Integer> {


    private final int capacity;

    public LRUCacheWithLinkedHashMap(int capacity) {
        super(capacity,0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }


    public void put(int key, int value) {
        put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
