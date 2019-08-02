package leetcode.algorithm;

/**
 * @Auther: ZhaoCong
 * @Date: 2018/11/16 17:11
 * @Description:
 */
public class NumberofAtoms {
    public static void main(String args[]) {
        int[][] ghosts={{1,0},{11,0},{21,0},{31,0},{41,0},{51,0},{61,0},{71,0},{81,0},{91,0},{101,0},{111,0},{121,0},{131,0},{141,0},{151,0},{161,0},{171,0},{181,0},{191,0},{201,0},{211,0},{221,0},{231,0},{241,0},{251,0},{261,0},{271,0},{281,0},{291,0},{301,0},{311,0},{321,0},{331,0},{341,0},{351,0},{361,0},{371,0},{381,0},{391,0},{401,0},{411,0},{421,0},{431,0},{441,0},{451,0},{461,0},{471,0},{481,0},{491,0},{501,0},{511,0},{521,0},{531,0},{541,0},{551,0},{561,0},{571,0},{581,0},{591,0},{601,0},{611,0},{621,0},{631,0},{641,0},{651,0},{661,0},{671,0},{681,0},{691,0},{701,0},{711,0},{721,0},{731,0},{741,0},{751,0},{761,0},{771,0},{781,0},{791,0},{801,0},{811,0},{821,0},{831,0},{841,0},{851,0},{861,0},{871,0},{881,0},{891,0},{901,0},{911,0},{921,0},{931,0},{941,0},{951,0},{961,0},{971,0},{981,0},{991,0}};
        int[] target={-10000,10000};
        System.out.println(escapeGhosts(ghosts,target));

    }

    public static boolean escapeGhosts(int[][] ghosts, int[]target) {
        int[] root = {0, 0};
        int minSteps = 20001;
        int mySteps = totalSteps(root, target);
        for (int i = 0; i < ghosts.length; i++) {
            int temp = totalSteps(ghosts[i], target);
            if (temp < mySteps) {
                minSteps = temp;
            }
        }
        if (minSteps < mySteps) {
            return false;
        } else {
            return true;
        }

    }

    public static int totalSteps(int[] root, int[] target) {
        return (Math.abs(target[0]- root[0]) + Math.abs(target[1] - root[1]));
    }


}
