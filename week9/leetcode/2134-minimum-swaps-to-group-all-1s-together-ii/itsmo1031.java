class Solution {
	public int minSwaps(int[] nums) {
		int oneCnt = 0;

		for (int num : nums) {
			if (num == 1) {
				oneCnt += 1;
			}
		}

		int zero = 0;

		for (int i = 0; i < oneCnt; i++) {
			if (nums[i] == 0) {
				zero += 1;
			}
		}

		int answer = zero;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == 0) {
				zero--;
			}

			if (nums[(i + oneCnt - 1) % nums.length] == 0) {
				zero++;
			}

			answer = Math.min(zero, answer);
		}

		return answer;
	}
}
