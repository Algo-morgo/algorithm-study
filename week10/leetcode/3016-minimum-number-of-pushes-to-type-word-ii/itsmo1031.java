import java.util.*;

class Solution {
	public int minimumPushes(String word) {
		int answer = 0;
		int[] freq = new int[26];

		for (char ch : word.toCharArray()) {
			freq[ch - 'a']++;
		}

		Arrays.sort(freq);

		for (int i = 0; i < 26; i++) {
			if (freq[25 - i] == 0) {
				break;
			}
			answer += freq[25 - i] * (i / 8 + 1);
		}

		return answer;
	}
}
