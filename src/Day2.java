public class Day2 {
    public int removeElement(int[] nums, int val) {
        int j = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]!=val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end ){
            int mid=  (end+start)/2;
            if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid] < target){
                start = mid+1;
            }else {
                return mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        Day2 d = new Day2();
        //6 --- mid=0+4/2 =2  start = 3 end = 4 3 +(4-3)/2 = 3
        System.out.println(d.removeElement(new int[]{1,2,2,3,4,4,4,},4));
        System.out.println(d.searchInsert(new int[]{1,3,5,7,8},4));
    }
}
