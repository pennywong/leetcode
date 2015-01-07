import java.util.HashMap;
import java.util.Map;

/**
 * Created by Penny on 2015/01/07
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int half = num.length / 2;
        if (num.length % 2 != 0)
            half++;
        for (int i = 0; i < num.length; i++) {
            Integer count = map.get(num[i]);
            if (count == null)
                count = 1;
            else
                count++;

            if (count >= half)
                return num[i];

            map.put(num[i], count);
        }

        return -1;
    }
}
