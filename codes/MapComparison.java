// ArrayMap<K,V> vs HashMap<K,V>

// ArrayMap provides the identical functionality as a hashMap but avoids all overhead by using two small arrays instead of one large one.
// ArrayMap designed to be more memory efficient than a traditional (java.util.HashMap) for 2 situations

 1. Situations where you have a small number of items (<1000)
 2. Situations where we have containers of maps. Like maps of maps where the sub maps tend to have a low number of items.

// ArrayMap
     ArrayMap<String, String> arrayMap = new ArrayMap<>();
     arrayMap.put("Key1", "Value1");
     ...
     for (int i = 0; i < arrayMap.size(); i++) {
         String key = arrayMap.keyAt(i);
         String value = arrayMap.valueAt(i);
     }

// HashMap
     HashMap<String, String> map = new HashMap< String, String>();
     map.put("Key1", "Value1");
     ...
     for(Iterator it = map.iterator(); it.hasNext();) {
         Object obj = it.next();
         ...
     }