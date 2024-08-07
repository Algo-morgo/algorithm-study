class Solution {
    public int minimumPushes(String word) {
        int[] cntArr = new int[26];
        for (int charIdx = 0; charIdx < word.length(); charIdx++) {
            cntArr[word.charAt(charIdx) - 'a']++;
        }

        Arrays.sort(cntArr);

        int answer = 0;
        for (int alphabet = 0; alphabet < 26; alphabet++) {
            answer += (alphabet / 8 + 1) * cntArr[26 - alphabet - 1];
        }

        return answer;
    }
}
