import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p/>
 * Created by Penny on 2014/12/19
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer lastIndex = map.get(c);
            if (lastIndex != null && lastIndex >= start) {
                max = Math.max(max, i - start);
                start = lastIndex + 1;
            }

            map.put(c, i);
        }

        max = Math.max(max, s.length() - start);

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, i);
                count++;
                i++;
            } else {
                max = max < count ? count : max;
                int index = map.get(c);
                for (int k = i - count; k <= index; k++)
                    map.remove(s.charAt(k));
                count = i - index - 1;
            }
        }

        return max > count ? max : count;
    }
}
