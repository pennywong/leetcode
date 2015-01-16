import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * <p/>
 * Created by Penny on 2015/01/15
 */
public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Character, String[]> map = new HashMap<Character, String[]>();
        map.put('0', new String[]{" "});
        map.put('1', new String[]{"1"});
        map.put('2', new String[]{"a", "b", "c"});
        map.put('3', new String[]{"d", "e", "f"});
        map.put('4', new String[]{"g", "h", "i"});
        map.put('5', new String[]{"j", "k", "l"});
        map.put('6', new String[]{"m", "n", "o"});
        map.put('7', new String[]{"p", "q", "r", "s"});
        map.put('8', new String[]{"t", "u", "v"});
        map.put('9', new String[]{"w", "x", "y", "z"});


        List<String> result = new LinkedList<String>();
        for (int i = 0; i < digits.length(); i++) {
            List<String> list = new LinkedList<String>();
            String[] strings = map.get(digits.charAt(i));
            for (int j = 0; j < strings.length; j++) {
                if (result.size() == 0)
                    list.add(strings[j]);
                else {
                    for (int k = 0; k < result.size(); k++) {
                        String string = result.get(k) + strings[j];
                        list.add(string);
                    }
                }
            }
            result = list;
        }

        for (int i = 0; i < result.size(); i++)
            result.set(i, result.get(i).trim());
        if (result.size() == 0)
            result.add("");
        return result;
    }
}
