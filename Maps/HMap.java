package Maps;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HMap {
    public static void main(String[] args) {
        // // creating a new hashmap
        // // 1)it doesn't contains dupicate keys ie always unique elements
        // // where as values can be duplicate;
        // // random order of insertion
        // // data structure is arrays of linkedlist
        // HashMap<String,Integer> hm= new HashMap<>();

        // // adding object to a hashmap
        // // in map, .put() function is used whereas in set and list .add() function is used
        // hm.put("India",121);
        // hm.put("China", 130);
        // hm.put("Us", 100);

        // System.out.println(hm);

        // // when adding elemnt which have same key will only change its value
        // // ie vlaue for corresponding key is updated.
        // hm.put("India",123);
        // System.out.println(hm);
        
        // // to get value of a key
        // int val=hm.get("India");
        // System.out.println(val);

        // // to check if key is present in map
        // System.out.println(hm.containsKey("india"));

        // // to check if value is present in map
        // System.out.println(hm.containsValue(123));

        // // size of map
        // System.out.println(hm.size());

        // // remove an object 
        // System.out.println( hm.remove("India"));
        // System.out.println(hm);

        // // iterate on maps
        // // keyset returns set of keys
        // Set<String> keyset= hm.keySet();
        // for(String s:hm.keyset){ // we can directy use hm.keySet() without stroing it into new set(extra space)
        //     System.out.println("key = "+s+" value = "+hm.get(s));
        // }

        // keyset.stream().filter((e,b)->Math.max(e,b));

        // // entrySet return all the entry in a map
        // Set s1= hm.entrySet();
        // for(Map.Entry<String, Integer> es:hm.entrySet()){
        //     System.out.println(es.getKey());
        // }
        // System.out.println(s1);

        // // linkedHashMap
        // // keep track of insertion order
        // // data structure is double linkedlist
        // // all operations same as hashmap
        // LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();

        // // TreeMap
        // // maintains natural sorting order is asscending
        // // data structure is radbalck trees(self balancing bst's)
        // TreeMap<String,Integer> tm= new TreeMap<>();
    }    
}
