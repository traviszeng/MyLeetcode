import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/17.
 */
class MapSum {

    /** Initialize your data structure here. */

    public Map<String,Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,val);
        }

        else map.put(key,val);
    }

    public int sum(String prefix) {
        int sum=0;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            if(key.startsWith(prefix)) sum+=map.get(key);
        }
        return sum;
    }
}

