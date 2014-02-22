public class LRUCache {
    
    int _capacity;
    int size;
    int earliest;
    int latest;
    HashMap<Integer, Integer> cache;
    HashMap<Integer, Integer> keyTime;
    HashMap<Integer, Integer> timeKey;
    
    public LRUCache(int capacity) {
        _capacity = capacity;
        size = 0;
        earliest = 0;
        latest = -1;
        cache = new HashMap<Integer, Integer>();
        keyTime = new HashMap<Integer, Integer>();
        timeKey = new HashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            updateKey(key);
            return cache.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (!cache.containsKey(key)) {
            cache.put(key, value);
            latest++;
            keyTime.put(key, latest);
            timeKey.put(latest, key);
            if (size < _capacity) {
                size++;
            } else {
                while (!timeKey.containsKey(earliest) && earliest <= latest) {
                    earliest++;
                }
                int earliestKey = timeKey.get(earliest);
                timeKey.remove(earliest);
                keyTime.remove(earliestKey);
                cache.remove(earliestKey);
            }
        } else {
            cache.put(key, value);
            updateKey(key);
        }
    }
    
    public void updateKey(int key) {
        int pre = keyTime.get(key);
        keyTime.put(key, ++latest);
        timeKey.remove(pre);
        timeKey.put(latest, key);
    }
}