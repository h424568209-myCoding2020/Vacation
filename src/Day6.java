import java.util.Arrays;

public class Day6 {
    public String reverseOnlyLetters(String S) {
      char []chars = S.toCharArray();
      for(int i = 0 ,j = S.length()-1 ; i<j; i++,j--){
          while(j>i){
              char c = chars[i];
              if(c>='A'&&c<='Z'||c>='a'&&c<='z'){
                  break;
              }
              i++;
          }
          while(j>i){
              char c = chars[j];
              if(c>='A'&&c<='Z'||c>='a'&&c<='z'){
                  break;
              }
              j--;
          }
          swap(chars,i,j);
      }
      return new String(chars);
    }

    private void swap(char[] chars,int left, int right) {
        char temp = chars[left];
        chars[left]=chars[right];
        chars[right] = temp;
    }

    public int[] sortedSquares(int[] A) {
        for(int i = 0 ; i < A.length ;  i++){
            if(A[i]<0){
                A[i] = -A[i];
            }
            A[i] = (int) Math.pow(A[i],2);
        }
       Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        Day6 d = new Day6();
        System.out.println(Arrays.toString(d.sortedSquares(new int[]{-2, 0, 1, 9})));

        System.out.println(d.reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
