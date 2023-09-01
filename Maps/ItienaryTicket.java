package Maps;

import java.util.HashMap;

public class ItienaryTicket {
    // itineary mean to find starting to end path in a journey.

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("chennai","bengaluru");
        map.put("mumbai","delhi");
        map.put("goa","chennai");
        map.put("delhi","goa");

        String start= getStart(map);

        path(map,start);

    }

    // intituion is to find the starting point .
    // ie location that is not reachable from any starting point.
    // it can be acehived by taking 2 map, 1st one cantiond key as starting point
    // 2nd map containing destination as key.
    // then we campare both map's keys, which ever is not present in the 2nd map will be starting point. 
    private static void path(HashMap<String, String> map, String start) {
        System.out.print(start);
        // using foreach loop to iterate
        for(String key: map.keySet()){
            System.out.print("->"+map.get(start));
            start=map.get(start);
        }
    }

    // we have to create a map in which key are destionation in orignal map;
    // then we need to check with keyset, which ever element is missing be the starting point 
    private static String getStart(HashMap<String, String> map) {
        HashMap<String, String> revMap= new HashMap<>();
        for(String key:map.keySet()){
            revMap.put(map.get(key),key);
        }

        for(String key:map.keySet()){
            if(!revMap.containsKey(key))
                return key;
        }
        return null;
    }
}
