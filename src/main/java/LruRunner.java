public class LruRunner {
    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);

//        add elements
        lruCache.put(1, "a");
        lruCache.put(2, "b");
        lruCache.put(3, "c");
        System.out.println("After 3 additions : Keys are in order : " + lruCache.getKeyStore());

        String getValue = lruCache.get(1);
        System.out.println("getValue - " + getValue);
        System.out.println("After 1 get : Keys are in order : " + lruCache.getKeyStore());

//        add one more element : lru elem will also be removed as capcity is reached
        lruCache.put(4, "d");
        System.out.println("After 4th add : Keys are in order : " + lruCache.getKeyStore());
    }
}
