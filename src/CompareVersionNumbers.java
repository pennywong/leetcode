/**
 * https://oj.leetcode.com/problems/compare-version-numbers/
 * <p/>
 * Created by Penny on 2015/01/13
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");

        int i = 0;
        int j = 0;
        while (i < strings1.length || j < strings2.length) {
            int x1 = i < strings1.length ? Integer.parseInt(strings1[i]) : 0;
            int x2 = j < strings2.length ? Integer.parseInt(strings2[j]) : 0;

            if (x1 > x2)
                return 1;
            else if (x1 < x2)
                return -1;

            i++;
            j++;
        }

        return 0;
    }
}
