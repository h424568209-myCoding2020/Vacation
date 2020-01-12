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
    public static void main(String[] args) {
        int a = 20,b = 5;
        //25255
        System.out.println(a+b+""+(a+b)+b);
        Day1 d = new Day1();
        d.mystery(1234);
        String s = "DDCDAAb";
        System.out.println(d.toLowerString(s));
    }
}
