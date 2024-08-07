import java.util.*;

class Solution {
    Map<String, Integer> map;
    int max = 0;
    
    void dfs(String order, String key, int currentIdx, int end, int depth) {
        if (depth == end) {
            map.put(key, map.getOrDefault(key, 0) + 1);
            max = Math.max(max, map.get(key));
            return;
        }
        
        for (int idx = currentIdx + 1; idx < order.length(); idx++) {
            dfs(order, key + order.charAt(idx), idx, end, depth + 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> tmpList = new ArrayList<>();
        
        for (int num : course) {
            map = new HashMap<>();
            max = 0;
            for (String order: orders) {
                char[] chArr = order.toCharArray();
                Arrays.sort(chArr);
                order = new String(chArr);

                dfs(order, "", -1, num, 0);
            }
            
            for (String key : map.keySet()) {
                int value = map.get(key);
                if (value > 1 && max == value) {
                    tmpList.add(key);
                }
            }
        }
        
        Collections.sort(tmpList);
        String[] answer = new String[tmpList.size()];
        for(int strIdx = 0; strIdx < tmpList.size(); strIdx++) {
            answer[strIdx] = tmpList.get(strIdx);
        }
        
        return answer;
    }
}
