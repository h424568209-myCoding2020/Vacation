import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

        public int longestIncreasingPath ( int[][] matrix){
            System.out.println(Arrays.deepToString(matrix));
            if (matrix.length == 0) return 0;
            m = matrix.length;
            n = matrix[0].length;
            int[][] cache = new int[m][n];
            int ans = 0;
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j) {
                    System.out.println("ans1 = " + ans);
                    ans = Math.max(ans, dfs(matrix, i, j, cache));
                    System.out.println("ans2 = " + ans);
                }
            return ans;
        }

        private int dfs ( int[][] matrix, int i, int j, int[][] cache){
            if (cache[i][j] != 0) return cache[i][j];
            for (int[] d : dirs) {
                System.out.println("d"+ Arrays.toString(d));
                int x = i + d[0], y = j + d[1];
                System.out.println("x" + x);
                System.out.println("y" + y);
                if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
                    cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
                    System.out.println("cache[i][j] = " + cache[i][j]);
                }
            }
            return ++cache[i][j];
        }



    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i =0 ; i < nums.length ; i++){
            int sz = list.size();
            for(int j = 0 ; j < sz ; j++){
                List<Integer> tmp = new ArrayList<>(list.get(j));
                tmp.add(nums[i]);
                list.add( tmp);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Day13 d = new Day13();
        System.out.println(d.subsets(new int[]{1,2,3}));
        System.out.println(d.longestIncreasingPath(new int[][]{ {9,9,4},
        {6,6,8},
        {2,1,1}
    }));
}
}
