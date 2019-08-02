package leetcode.algorithm;

/**
 * @author zhaocong
 * @ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━龙妈保佑，永无BUG━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * @ -
 * @ -
 * @ -                                                    __----~~~~~~~~~~~------___
 * @ -                                   .  .   ~~//====......          __--~ ~~
 * @ -                   -.            \_|//     |||\\  ~~~~~~::::... /~
 * @ -                ___-==_       _-~o~  \/    |||  \\            _/~~-
 * @ -        __---~~~.==~||\=_    -_--~/_-~|-   |\\   \\        _/~
 * @ -    _-~~     .=~    |  \\-_    '-~7  /-   /  ||    \      /
 * @ -  .~       .~       |   \\ -_    /  /-   /   ||      \   /
 * @ - /  ____  /         |     \\ ~-_/  /|- _/   .||       \ /
 * @ - |~~    ~~|--~~~~--_ \     ~==-/   | \~--===~~        .\
 * @ -          '         ~-|      /|    |-~\~~       __--~~
 * @ -                      |-~~-_/ |    |   ~\_   _-~                /\
 * @ -      龙妈保佑                 /  \     \__   \/~                \__
 * @ -                       _--~ _/ | .-~~____--~-/                  ~~==.
 * @ -                      ((->/~   '.|||' -_|    ~~-/ ,              . _||
 * @ -                                 -_     ~\      ~~---l__i__i__i--~~_/
 * @ -                                 _-~-__   ~)  \--______________--~~
 * @ -                               //.-~~~-~_--~- |-------~~~~~~~~
 * @ -                                      //.-~~~--\
 * @ ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━龙妈保佑，永无BUG━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * @date 2019-07-18
 * @description:
 */
public class IsBipartite {

  public static void main(String[] args) {
    int[][] test2 = {{1}, {0, 3}, {3}, {1, 2}};
    int[][] test = {{2, 4}, {2, 3, 4}, {0, 1}, {1}, {0, 1}, {7}, {9}, {5}, {}, {6}, {12, 14},
      {},
      {10}, {}, {10}, {19}, {18}, {}, {16}, {15}, {23}, {23}, {}, {20, 21}, {}, {}, {27}, {26}, {},
      {}, {34}, {33, 34}, {}, {31}, {30, 31}, {38, 39}, {37, 38, 39}, {36}, {35, 36}, {35, 36},
      {43}, {}, {}, {40}, {}, {49}, {47, 48, 49}, {46, 48, 49}, {46, 47, 49}, {45, 46, 47, 48}};

    /**
     * 0,1
     */
    /**
     * 2,4,3,
     */

    System.out.println(isBipartite(test));
  }

  public static boolean isBipartite(int[][] graph) {

    int length = graph.length;
    if (length <= 2) {
      return true;
    }
    /**
     * 节点的颜色，0为无色，1，2两种颜色
     */
    int[] nodeColor = new int[length];
    /**
     * 染过色的节点数
     */
    int coloredNodeSum = 0;
    int allowColorNode = 0;
    for (int[] node : graph) {
      if (node.length > 0) {
        allowColorNode++;
      }
    }
    while (coloredNodeSum < allowColorNode && coloredNodeSum < length) {
      int coloredNodeNum = 0;
      for (int i = 0; i < length; i++) {
        /**
         * 当前节点没有链接的时候，跳过
         */
        if (graph[i].length < 1) {
          continue;
        }
        /**
         * 初始化第一个有链接的节点
         */
        if (coloredNodeNum == 0) {
          nodeColor[i] = 1;
          coloredNodeNum++;
        }
        /**
         * 如果当前节点有颜色，给相邻节点染色,如果相邻节点颜色和当前颜色一致则返回false
         * 如果没有颜色，判断相邻节点是否有颜色，再给自己染色，如果相邻节点的颜色不统一，返回false
         */
        if (hasColor(nodeColor[i])) {
          /**
           * 遍历相邻节点集合
           */
          int[] adjacentNode = graph[i];
          for (int j = 0; j < adjacentNode.length; j++) {
            if (nodeColor[i] == 1) {
              if (nodeColor[adjacentNode[j]] == 1) {
                return false;
              }
              if (nodeColor[adjacentNode[j]] == 0) {
                nodeColor[adjacentNode[j]] = 2;
                coloredNodeNum++;
              }
            }
            if (nodeColor[i] == 2) {
              if (nodeColor[adjacentNode[j]] == 2) {
                return false;
              }
              if (nodeColor[adjacentNode[j]] == 0) {
                nodeColor[adjacentNode[j]] = 1;
                coloredNodeNum++;
              }
            }
          }
        } else {
          /**
           * 相邻节点集合,当集合中有一个有颜色时，判断集合中是否有颜色不一样的，有就返回false，没有就给其他节点染色
           */
          int[] adjacentNode = graph[i];
          int adjacentNodeColor = 0;
          for (int j = 0; j < adjacentNode.length; j++) {
            if (hasColor(nodeColor[adjacentNode[j]])) {
              /**
               * 相邻节点集合中所遍历的节点有颜色，给当前节点染色
               */
              nodeColor[i] = nodeColor[adjacentNode[j]] == 1 ? 2 : 1;
              coloredNodeNum++;
              if (hasColor(adjacentNodeColor)) {
                /**
                 * 相邻节点集合中有一个节点有颜色
                 */
                if (adjacentNodeColor != nodeColor[adjacentNode[j]]) {
                  return false;
                }
              } else {
                /**
                 * 相邻节点集合中其他节点没有颜色，给集合染色
                 */
                adjacentNodeColor = nodeColor[adjacentNode[j]];
              }
            } else {
              /**
               * 相邻节点集合中所遍历的节点没有颜色，则染成集合的颜色
               */
              nodeColor[adjacentNode[j]] = adjacentNodeColor;
              coloredNodeNum++;
            }
          }
        }
      }
      coloredNodeSum += coloredNodeNum;
    }

    return true;
  }

  static boolean hasColor(int color) {
    return color == 1 || color == 2;
  }
}
