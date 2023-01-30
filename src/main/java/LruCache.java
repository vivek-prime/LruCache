import lombok.Data;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Data
public class LruCache {
    private int capacity;
    private Set<Integer> keyStore;
    private Map<Integer, String> cache;

    public LruCache(int capacity) {
        this.capacity = capacity;
        keyStore = new LinkedHashSet<>();
        cache = new HashMap<>();
    }

    public void put(Integer key, String value) {
        if (cache.size() == capacity)
            remove();
        cache.put(key, value);
        keyStore.add(key);
    }

    public String get(Integer key) {
//        update keystore so that newly accessed comes at the front of the LinkedHashSet
        keyStore.remove(key);
        keyStore.add(key);
        return cache.get(key);
    }

    public void remove() {
//        find oldest entry in keyStore : first element
        System.out.println("Before Deletion : Currently Keys are in order : " + keyStore);
        int delKey = keyStore.iterator().next();
        keyStore.remove(delKey);
        cache.remove(delKey);
        System.out.println("Key deleted : " + delKey);
        System.out.println("After Deletion : Currently Keys are in order : " + keyStore);
    }
}
