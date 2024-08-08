import java.util.*;

class Solution {
	static Map<Integer, String> tens;
	static Map<Integer, String> ones;

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}

		ones = new HashMap<>();

		ones.put(1, "One");
		ones.put(2, "Two");
		ones.put(3, "Three");
		ones.put(4, "Four");
		ones.put(5, "Five");
		ones.put(6, "Six");
		ones.put(7, "Seven");
		ones.put(8, "Eight");
		ones.put(9, "Nine");

		tens = new HashMap<>();

		tens.put(1, "Ten");
		tens.put(2, "Twenty");
		tens.put(3, "Thirty");
		tens.put(4, "Forty");
		tens.put(5, "Fifty");
		tens.put(6, "Sixty");
		tens.put(7, "Seventy");
		tens.put(8, "Eighty");
		tens.put(9, "Ninety");
		tens.put(11, "Eleven");
		tens.put(12, "Twelve");
		tens.put(13, "Thirteen");
		tens.put(14, "Fourteen");
		tens.put(15, "Fifteen");
		tens.put(16, "Sixteen");
		tens.put(17, "Seventeen");
		tens.put(18, "Eighteen");
		tens.put(19, "Nineteen");

		StringBuilder answer = new StringBuilder();

		String[] thousands = { "", " Thousand ", " Million ", " Billion " };
		StringBuilder tmp = new StringBuilder();
		int i = 0;
		while (num > 0) {
			tmp.setLength(0);
			int target = num % 1_000;
			num /= 1_000;

			if (target == 0) {
				i++;
				continue;
			}

			tmp.append(getHundreds(target)).append(thousands[i++]);

			answer.insert(0, tmp);
		}

		return answer.toString().trim();
	}

	static String getHundreds(int num) {
		StringBuilder sb = new StringBuilder();

		int hundred = num / 100;
		int ten = num % 100;

		if (hundred != 0) {
			sb.append(ones.get(hundred)).append(" Hundred ");
		}

		if (11 <= ten && ten < 20) {
			sb.append(tens.get(ten));
			return sb.toString();
		}

		int tenNum = ten / 10;
		int one = ten % 10;

		if (tenNum != 0) {
			sb.append(tens.get(tenNum)).append(" ");
		}

		if (one != 0) {
			sb.append(ones.get(one));
		}
		return sb.toString().trim();
	}
}
