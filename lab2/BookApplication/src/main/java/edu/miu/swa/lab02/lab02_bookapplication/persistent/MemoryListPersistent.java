package edu.miu.swa.lab02.lab02_bookapplication.persistent;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class MemoryListPersistent<T, K> {
   HashMap<K, T> cache = new HashMap<>();

    public T addItem(T item, K key ) {
        if (!cache.containsKey(key))
            cache.put(key, item);
        return item;
    }

    public T getItem(K key) {
        return cache.get(key);
    }

    public T updateItem(T item, K key) {
      return cache.put(key, item);
    }

    public T deleteItem(K key) {
       return cache.remove(key);
    }

    public List<T> getAllItem(){
        return cache.values().stream().toList();
    }
}
