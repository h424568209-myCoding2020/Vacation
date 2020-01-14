import java.util.Arrays;

public class Day4 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n-1;
        int l = m-1;
        int s = n-1;
        while(l >=0 && s>=0){
            nums1[len--]=(nums1[l]>nums2[s]?nums1[l--]:nums2[s--]);
        }
        System.arraycopy(nums2, 0, nums1, 0, s + 1);
    }
    public int lengthOfLastWord(String s) {
        if(s==null){
            return 0;
        }
       s= s.trim();
        int i = s.length()-1;
        int count =0 ;
        for(; i >=0 ; i--){
            if(s.charAt(i)!=' '){
                count++;
            }else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        Day4 d = new Day4();
        System.out.println(d.lengthOfLastWord("a"));
        d.merge(new int[]{1,3,4,20,0,0,0},4,new int[]{7,8,9},3);
    }
}
