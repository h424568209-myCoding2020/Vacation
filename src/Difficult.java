public class Difficult {
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
    }
}
