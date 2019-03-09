package algorithm;

import java.util.Arrays;

/**
 * @Auther: ZhaoCong
 * @Date: 2018/11/14 16:45
 * @Description:
 */
public class KnightProbability {
    public static void main(String args[]) {
        System.out.println(knightProbability(4, 4, 0, 0));
    }

    public static double knightProbability(int N, int K, int r, int c) {
        double[][] dp=new double[N][N];
        for(double[] d:dp){
            Arrays.fill(d,1);
        }
        int[][] dt={{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
        for(int k=1;k<=K;k++){
            double[][] t=new double[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int[] d:dt){
                        int x=i+d[0];
                        int y=j+d[1];
                        if(x<0||x>=N||y<0||y>=N) {
                            continue;
                        }
                        t[i][j]+=dp[x][y];
                    }
                }
            }
            dp=t;
        }
        return dp[r][c]/Math.pow(8,K);
    }
}
