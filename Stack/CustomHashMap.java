import java.util.LinkedList;

class Entry<K, V> {
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap<K, V> {
    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    private int getIndex(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if ((entry.key == null && key == null) || (entry.key != null && entry.key.equals(key))) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if ((entry.key == null && key == null) || (entry.key != null && entry.key.equals(key))) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
             if ((entry.key == null && key == null) || (entry.key != null && entry.key.equals(key))) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            bucket.remove(toRemove);
            size--;
        }
    }

    public int size() {
        return size;
    }
}
