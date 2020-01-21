import java.util.Arrays;
import java.util.Stack;

public class Day12 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ; i < tokens.length ; i++){
            switch (tokens[i]){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "-":
                    int t = stack.pop();
                    stack.push(stack.pop()-t);
                    break;
                case "/":
                    int s = stack.pop();
                    stack.push(stack.pop()/s);
                    break;
                    default:
                        stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length ; int r = 0;
        for(int i = 0 ; i < nums.length-1 ; i++){
            for(int j = i+1 ; j < nums.length ;j++){
                if(nums[j]< nums[i]){
                    r = Math.max(r,j);
                    l = Math.min(l,i);
                }
            }
        }
        if(r - l<0){
            return 0;
        }
        return r-l+1;
    }
    public int findUnsortedSubarrays(int[] nums) {
        int [] res = nums.clone();
        Arrays.sort(nums);
        int left = nums.length;
        int right = 0;
        for(int i = 0  ; i < nums.length ; i++){
            if(res[i] != nums[i]){
                left = Math.min(left,i);
                right = Math.max(right,i);
            }
        }
        return right-left<0?0:right-left+1;
    }
    public static void main(String[] args) {
        System.out.println(Math.cos(Math.toDegrees(43 )));
        Day12 d = new Day12();
        System.out.println(d.findUnsortedSubarray(new int[]{3,2,1}));

        System.out.println(d.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
