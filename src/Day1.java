import java.util.Arrays;

public class Day1 {
    public void mystery(int x){
        System.out.println(x%10);
        if(x/10!=0){
            mystery(x/10);
        }
        System.out.println(x%10);
    }
    public String toLowerString(String str){
        if(str==null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);
           if(c>=65 && c<=90){
               c+=32;
           }
            sb.append(c);
        }
        return sb.toString();
    }
    public void  rotate(int []nums,int k ){
        int n = nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start, int end) {
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end  ];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void  rotate1(int []nums,int k ){
        int n = nums.length;
        k%=n;
        /*
        1 2 3 4 5 6   k = 2;
        5 6 1 2 3 4
         */
        for(int i = 0 ; i < k ; i++){
            int temp = nums[i];
            for(int j = n-1 ; j > 0 ; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int a = 20,b = 5;
        //25255
        System.out.println(a+b+""+(a+b)+b);
        Day1 d = new Day1();
        d.mystery(1234);
        String s = "DDCDAAb";
        System.out.println(d.toLowerString(s));
        d.rotate(new int[]{1,2,3,4,5},3);
    }
}
