import java.util.Arrays;

public class Day10 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==1 && nums[0] == target){
            return new int[]{0,0};
        }
        return searchMid(nums,0,nums.length-1,target);
    }

    private int[] searchMid(int[] nums, int i, int len, int target) {
        if (i > len) {
            return new int[]{-1,-1};
        }
        while(i<=len){
            int mid = (i+len)/2;
            if(nums[mid]>target){
                return searchMid(nums,i,mid-1,target);
            }
           else if(nums[mid]< target){
                return searchMid(nums,mid+1,len,target);
            }
            else{
                while(0<=mid&&nums[mid] == target ){
                    mid--;
                }
                int l  = mid+1;
                while(mid< len && nums[mid+1]==target){
                    mid++;
                }
                int r = mid;
                return new  int[]{l,r};
            }
        }
        return new int[]{-1,-1};
    }

    public int myAtoi(String str) {

        int res= 0 ;
        char[] chars = str.toCharArray();
        int len = str.length();
        int flag=  1;
        int i = 0;
        for( ; i < len; i++){
            if(chars[i] == ' '){
                continue;
            }else {
                if(chars[i] == '-'){
                    flag = -1;
                    i++;
                    break;
                }
                if(chars[i]=='+'){
                    i++;
                    break;
                }
                if (chars[i] > '9' || chars[i] < '0') {
                    return 0;
                }
                else {
                    break;
                }
            }
        }
        if(i == len){
            return  0;
        }
        for(;i<str.length() ; i++){
            int pop = (chars[i]-'0')*flag;
            if(chars[i]>'9'||chars[i]<'0'){
                return res;
            }
            if(res>Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && pop > 7)){
                return Integer.MAX_VALUE;
            }
            if(res<Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && pop < -8)){
                return Integer.MIN_VALUE;
            }
            res = res*10  + pop;
        }
        return res;    }

    public static void main(String[] args) {
        Day10 d = new Day10();
        System.out.println(d.myAtoi("-1 "));

        System.out.println(Arrays.toString(d.searchRange(new int[]{1, 1, 1, 2, 3, 4, 4, 5, 5, 9}, 5)));
    }
}
