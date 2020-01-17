import java.util.Arrays;

public class Day7 {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int maxL = 0;
        int maxR = 0;
        //1 7 3 6 5 6
        //1 2 3
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ;j++){
                maxL +=nums[j];
            }
            for(int j = i+1 ; j<nums.length ; j++){
                maxR += nums[j];
            }
            if(maxL == maxR){
                return i;
            }
            maxL = 0;
            maxR = 0;
        }
        return -1;
    }
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length-1;
        while(left<right){
            while(left<right&&A[left]%2==0){
                left++;
            }
            while(right>left&&A[right]%2==1){
                right--;
            }
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
        return A;
    }
    public static void main(String[] args) {
        Day7 d  = new Day7();
        System.out.println(Arrays.toString(d.sortArrayByParity(new int[]{2,4})));
        System.out.println(d.pivotIndex(new int[]{1,2,3,4,3,2,1,1,-1}));
    }
}
