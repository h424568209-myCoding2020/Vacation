import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11 {
    public int compress(char[] chars) {
        StringBuffer sb = new StringBuffer();
        char curchar = chars[0];
        int len = 1;
        for(int i = 0 ; i < chars.length -1 ; i++){
            if(chars[i] == chars[i+1]){
                curchar = chars[i];
                len++;
            }else{
                sb.append(curchar);
                if(len>1){
                    sb.append(len);
                }
                curchar = chars[i+1];
                len =1;
            }
        }
        if(len>1){
            sb.append(curchar);
            sb.append(len);
        }else {
            sb.append(curchar);
        }
        char[]res = sb.toString().toCharArray();
        for(int i = 0 ; i < res.length ; i++){
            chars[i] = res[i];
        }
        return sb.length();
    }
    public boolean isPalindrome(String s) {
        if(s==null){
            return true;
        }
        s=s.toLowerCase();
        int l  =s.length();
        StringBuffer sb = new StringBuffer(l);
        for(char c: s.toCharArray()){
            if((c>='0'&&c<='9')||(c>='a'&&c<='z')){
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        Day11 d = new Day11();
        System.out.println(d.isPalindrome("race a car"));
        System.out.println(d.compress(new char[]{'a','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c' }));
    }
}
