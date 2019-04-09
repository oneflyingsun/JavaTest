package algorithm;

/**
 * @Author: ZhaoCong
 * @Date: 2019-01-24
 * @Description:
 */
public class NQueens {
    //列，某一列是否被占用
    int[] col;
    //正对角线
    int[] isDiagonal;
    //斜对角线
    int[] obliqueDiagonal;
    public static void main(String[] args) {
        long oldTime = System.nanoTime();
        int result = new NQueens().totalNQueens(8);
        System.out.println(result);
        System.out.println("Time:========:" + (System.nanoTime() - oldTime));
    }

    /**
     * 初始化
     *
     * @param n 皇后数
     * @return
     */
    public int totalNQueens(int n) {
        col = new int[n];
        isDiagonal = new int[2 * n - 1];
        obliqueDiagonal = new int[2 * n - 1];
        return putQueen(n, 0);
    }

    /**
     * 开始放置皇后
     *
     * @param n        总皇后数
     * @param queenNum 已放置皇后数
     * @return
     */
    public int putQueen(int n, int queenNum) {
        int result = 0;
        if (queenNum == n) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            //判断是否能放皇后
            if (col[i] == 0 && obliqueDiagonal[queenNum + i] == 0 && isDiagonal[queenNum - i + n - 1] == 0) {
                //皇后放在此处，并标记此皇后攻击的点
                col[i] = 1;
                isDiagonal[queenNum - i + n - 1] = 1;
                obliqueDiagonal[queenNum + i] = 1;
                result += putQueen(n, queenNum + 1);

                //解除标记，继续移动皇后
                col[i] = 0;
                isDiagonal[queenNum - i + n - 1] = 0;
                obliqueDiagonal[queenNum + i] = 0;
            }
        }
        return result;
    }
}
