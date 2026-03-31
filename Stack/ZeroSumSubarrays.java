import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Subarray {
    int start, end;
    Subarray(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ZeroSumSubarrays {
    public static List<Subarray> findSubarrays(int[] arr) {
        List<Subarray> out = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        insert(map, 0, -1);
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (Integer value : list) {
                    out.add(new Subarray(value + 1, i));
                }
            }
            insert(map, sum, i);
        }
        return out;
    }

    private static void insert(Map<Integer, List<Integer>> map, int key, int index) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(index);
    }
}
