/**
 * Problem Link: https://oj.leetcode.com/problems/zigzag-conversion/
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P * A * H * N
 * 
 * A N L S I I G
 * 
 * Y * I * R *
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author Penny
 *
 */
public class ZigZag {
	/**
	 * ZigZag形式是一个倒Z型
	 * 
	 * 0 * * 6 * * C
	 * 
	 * 1 * 5 7 * B D
	 * 
	 * 2 4 * 8 A * E
	 * 
	 * 3 * * 9 * * F
	 * 
	 * 然后从上到下，从左到右进行扫描返回，从中可以看出，排除中间的zag部分，每个数字之间的差都是2*row-2(row>=2)，例如第一行的0, 6,
	 * C，第二行的1, 7, D都是相差6
	 * 
	 * 而当不是第一行和最后一行，两个中间都会有zag，而zag的位置都是相差的值减去i*2，例如第二行i=1，5=1+6-1*2，B=7+6-1*2;
	 * 第三行i=2, 4=2+6-2*2, A=8+6-2*2
	 * 
	 * 算法复杂度是O(N)
	 * 
	 */
	public String convert(String s, int nRows) {
		if (nRows <= 1 || s == null || s.length() <= nRows)
			return s;

		int step = 2 * nRows - 2;

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < nRows; i++) {
			int k = i;
			int zag_step = step - i * 2;
			while (k < s.length()) {
				if (k < s.length())
					result.append(s.charAt(k));

				if (i > 0 && i < (nRows - 1)) {
					int zag = k + zag_step;
					if (zag < s.length())
						result.append(s.charAt(zag));
				}

				k = k + step;
			}
		}

		return result.toString();
	}
}
