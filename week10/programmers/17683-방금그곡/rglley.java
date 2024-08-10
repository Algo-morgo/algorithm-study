import java.util.*;

class Solution {
    String getMelody(String melody, int playTime) {
        StringBuilder playedMelody = new StringBuilder();
        
        for (int time = 0; time < playTime; time++) {
            playedMelody.append(melody.charAt(time % melody.length()));
        }
        
        return playedMelody.toString();
    }
    
    int getTime(String start, String end) {
        String[] startSplit = start.split(":");
        String[] endSplit = end.split(":");
        
        int startHour = Integer.parseInt(startSplit[0]);
        int startMinute = Integer.parseInt(startSplit[1]);
        int endHour = Integer.parseInt(endSplit[0]);
        int endMinute = Integer.parseInt(endSplit[1]);
        
        return (endHour * 60 + endMinute) - (startHour * 60 + startMinute);
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;
        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a").replace("B#", "b"); 
        
        for (String info : musicinfos) {
            String[] details = info.split(",");
            String startTime = details[0];
            String endTime = details[1];
            String title = details[2];
            String melody = convert(details[3]); 
            
            int playTime = getTime(startTime, endTime);
            String playedMelody = getMelody(melody, playTime);

            if (playedMelody.contains(m)) {
                if (playTime > maxPlayTime || (playTime == maxPlayTime && answer.equals("(None)"))) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        
        return answer;
    }
}
