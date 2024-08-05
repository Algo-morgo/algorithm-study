class Solution {
	public int solution(int storey) {
		int answer = 0;
		while (storey > 0) {
			int lastDigit = storey % 10;
			int nextDigit = (storey / 10) % 10;

			if (lastDigit < 5) {
				answer += lastDigit;
				storey /= 10;
			} else if (lastDigit == 5) {
				if (nextDigit >= 5) {
					answer += 5;
					storey = storey / 10 + 1;
				} else {
					answer += 5;
					storey /= 10;
				}
			} else {
				answer += 10 - lastDigit;
				storey = storey / 10 + 1;
			}
		}

		return answer;
	}
}
