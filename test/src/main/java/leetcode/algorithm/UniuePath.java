package leetcode.algorithm;

/**
 * @Auther: ZhaoCong
 * @Date: 2018/11/15 22:14
 * @Description:
 */
public class UniuePath {
    public static void main(String args[]) {
        System.out.println(uniquePaths(7,3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] road = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    if(j==0){
                        road[i][j] = 1;
                    }else{
                        road[i][j] = road[i][j-1];
                    }
                }else{
                    if(j==0){
                        road[i][j]=road[i-1][j];
                    }else{
                        road[i][j]=road[i-1][j]+road[i][j-1];
                    }
                }
            }
        }
        return road[m-1][n-1];
    }
}
