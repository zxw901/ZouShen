package basic_class_05;

import java.util.HashMap;

public class Code_01_RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key) {
            if (!keyIndexMap.containsKey(key)) {
                keyIndexMap.put(key, size);
                indexKeyMap.put(size, key);
                size++;
            }

        }

        public K getRandom() {
            if (size == 0) {
                return null;
            }
            return indexKeyMap.get((int) (Math.random() * this.size));
        }

        public void delet(K key) {
            if (this.keyIndexMap.containsKey(key)) {
                int deleteIndex = keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastKey, deleteIndex);  //覆盖最后一行key的value，使其为被删除key的value
                indexKeyMap.put(deleteIndex, lastKey);  //用最后一行的key覆盖被删除行的key
                keyIndexMap.remove(key);
                indexKeyMap.remove(lastIndex);
            }
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
