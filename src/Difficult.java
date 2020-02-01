import java.awt.*;
import java.util.*;
import java.util.List;

public class Difficult {
    //通配符匹配  ?可以代表一个字符 ，* 可以代表多个字符
    public boolean isMatch(String s, String p) {
        int i = 0 ;
        int j = 0 ;
        int istart = -1;
        int jstart = -1;
        int m = s.length();
        int n = p.length();
        while(i< m){
                if (j<n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                    j++;
                    i++;
                } else if ( j<n && p.charAt(j) == '*') {
                    istart = i;
                    jstart = j++;
            }else if (istart >= 0) {
                i = ++istart;
                j = jstart + 1;
            }
            else
                return false;
        }

        while(j<n && p.charAt(j) == '*'){
            j++;
        }
        return  j==n;
    }
    //假设我们从 S 车站开始（初始时不在公交车上），要去往 T 站。 期间仅可乘坐公交车，求出最少乘坐的公交车数量。返回 -1 表示不可能到达终点车站。
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S==T){
            return 0;
        }
        int N  = routes.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++){
            Arrays.sort(routes[i]);
            graph.add(new ArrayList<>());
        }
        Set<Integer> seen = new HashSet<>();
        Set<Integer> target = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();

        for(int i = 0 ; i < N ; i++){
            for(int j = i+1; j < N ; j++){
                if(interset(routes[i],routes[j])){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        for(int i = 0 ; i <N ; i ++ ){
            if(Arrays.binarySearch(routes[i],S)>=0){
                seen.add(i);
                queue.offer(new Point(i,0));
            }
            if(Arrays.binarySearch(routes[i],T)>=0){
                target.add(i);
            }
        }
        while(!queue.isEmpty()){
            Point info = queue.poll();
            int node  = info.x;
            int depth = info.y;
            if(target.contains(node)){
                return depth+1;
            }
            for(Integer in : graph.get(node)){
                if(!seen.contains(in)){
                    queue.offer(new Point(in,depth+1));
                }
            }
        }
        return -1;
    }

    private boolean interset(int[] A, int[] B) {
        int i = 0 , j = 0;
        while(i< A.length  && j< B.length){
            if(A[i] == B [j]){
                return true;
            }
            if(A[i] < B[j]){
                i++;
            }else{
                j++;
            }
        }
        return false;
    }


    //找出二维数组中递增最长的路径
    public  final  int [][]dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    private int m ;
    private int n;
    public int longestIncreasingPath(int[][] matrix){
        if(matrix.length == 0){
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        int ans = 0 ;
        int[][]arr = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                ans= Math.max(ans,bfs(matrix,i,j,arr));
            }
        }
        return ans;
    }

    private int bfs(int[][] matrix, int i, int j,int[][]arr) {
        if(arr[i][j]!=0)
            return arr[i][j];
        for(int [] d : dirs){
            int a = i+d[0];
            int b = j +d[1];
            if(a>=0 && b >=0 && a<m&& b < n && matrix[a][b] > matrix[i][j]){
                arr[i][j] =  Math.max(arr[i][j],bfs(matrix,a,b,arr));
            }
        }
        return ++arr[i][j];
    }

    public static void main(String[] args) {
        int[][]arr = {{9,9,4},{6,6,8},{2,1,1}};
        Difficult d = new Difficult();
        System.out.println(d.longestIncreasingPath(arr));

        int[][]routes = {{1,2,7},{3,6,7}};
        System.out.println(d.numBusesToDestination(routes,1,6));

        System.out.println(d.isMatch("ssab","*?"));
    }
}
