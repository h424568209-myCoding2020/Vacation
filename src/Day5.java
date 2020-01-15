import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Day5 {
    private float f = 0.1f;
    int m =12;
    static  int n = 1;

    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()){
            return false;
        }
       int i = 0;
       int j =0 ;
        Queue<Character>queue1 = new LinkedList<>();
        Queue<Character> queue2 = new LinkedList<>();
       for(; i< name.length() ; i++){
           queue1.offer(name.charAt(i));
       }
       for(; j < typed.length() ;j++){
           queue2.offer(typed.charAt(j));
       }
       char c =' ';
       while(!queue1.isEmpty()){
           if(queue1.peek() == queue2.peek()){
               queue1.poll();
                c = queue2.poll();
           }else{
               if(queue2.isEmpty()){
                   return false;
               }
               if(c==queue2.peek()){
                   queue2.poll();
               }else{
                   return false;
               }
           }
       }
       while(!queue2.isEmpty()){
           if(c!=queue2.poll()){
               return false;
           }
       }
       return true;
    }
    public boolean isLongPressedNames(String name, String typed){
        int lena = name.length();
        int lent = typed.length();
        if(lena > lent){
            return false;
        }
        int i =0 ;
        int j = 0;
        while(i<lena && j<lent){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else {
                if(typed.charAt(j) == typed.charAt(j - 1)){
                    j++;
                }else
                    return false;
            }
        }
        return i==lena;
    }
    public boolean containsDuplicate(int[] nums) {
        if(nums.length ==1 || nums.length == 0){
            return false;
        }
        Arrays.sort(nums);
        for(int i = 1 ; i <nums.length ; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Day5 d = new Day5();
        System.out.println(d.containsDuplicate(new int[]{1, 2, 3, 4, 5}));
        System.out.println(d.isLongPressedName("a","a"));
    }
}
