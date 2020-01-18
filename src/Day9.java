import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day9 {
    public String addBinary(String a, String b) {
        if(a.length() == 0){
            return b;
        }
        if(b.length() ==0){
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = a.length()-1;
        int carry = 0;
        while( i >= 0 || j >= 0 ){
            if( i >= 0 ) { carry += a.charAt(i--)-'0'; }
            if( j >= 0 ) { carry += b.charAt(j--)-'0'; }
            sb.append( carry % 2 );
            carry >>= 1;
        }
        String res = sb.reverse().toString();
        return carry > 0 ? '1' + res : res;
    }
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i < nums.length-1 ; i++){
            for(int j = i+1 ; j< nums.length ; i++){
                if(nums[i]+ nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public int[] twoSummap(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                return new  int[]{i,nums[i]};
            }
            map.put(target-nums[i],i);
        }
        return null ;
    }
    public static void main(String[] args) {
        Day9 d = new Day9();
        System.out.println(Arrays.toString(d.twoSum(new int[]{4,2,1,3,4,5,6,1,2}, 5)));

        System.out.println(d.addBinary("111","1"));
    }
}
