import java.util.HashMap;
import java.util.Map;

public class Day3 {
public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length()-1;
        while (left<=right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
}
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=  new HashMap<>();
        for(int i = 0 ; i < magazine.length() ; i++){
            char c = magazine.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i =0 ; i < ransomNote.length() ; i++){
            char c = ransomNote.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }else {
                map.put(c,map.getOrDefault(c,1)-1);
                if(map.get(c)<0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Day3 d = new Day3();
        System.out.println(d.canConstruct("", "aecdbb"));
        System.out.println(d.isPalindrome(1221));
    }

}

