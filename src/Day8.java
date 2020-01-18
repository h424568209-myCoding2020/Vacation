import java.util.Arrays;

public class Day8 {
    public int thirdMaxOn(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        if(nums.length ==2){
            return Math.max(nums[0],nums[1]);
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int flag = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]>first){
                third = second;
                second = first;
                first = nums[i];
                flag++;
            }else if(nums[i]>second){
                third = second;
                second=  nums[i];
                flag++;
            }else if(nums[i]>third){
                third = nums[i];
                flag++;
            }
        }
        if(flag>=3){
            return third;
        }
        return first;
    }
        public int thirdMax(int[] nums) {
            Arrays.sort(nums);
            if(nums.length  <3){
                return nums[nums.length-1];
            }
            int count = 0;
            for(int i = nums.length-1; i >0 ; i--){
                if(nums[i]>nums[i-1]){
                    count++;
                }
                if(count==2){
                    return nums[i-1];
                }
            }
            return nums[nums.length-1];
}
    public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        int carry = 0 ;
        boolean flag = true;
        int num = 0;
        for(int i = digits.length-1 ; i >=0 ; i--){
            if(flag) {
                 num = digits[i] + 1;
                flag = false;
            }else {
                num = digits[i] + carry;
            }
            carry = num/10;
            num %= 10;
            sb.append(num);
        }
        if(carry == 1){
            sb.append(carry);
        }
        sb.reverse();
        int []res = new int[sb.length()];
        for(int i = 0 ; i < sb.length() ; i++){
            res[i] = sb.charAt(i)-'0';
        }
        return  res;
    }
    public static void main(String[] args) {
        Day8 d = new Day8();
        System.out.println(Arrays.toString(d.plusOne(new int[]{1,2,3})));
        System.out.println(d.thirdMax(new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(d.thirdMaxOn(new int[]{1,2,3,4,5}));
        }
}
