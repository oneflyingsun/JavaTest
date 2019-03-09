package algorithm;

import java.util.*;

/**
 * @Auther: ZhaoCong
 * @Date: 2018/11/20 19:32
 * @Description:
 */
public class LeetCodeTest {
    public static void main(String args[]) {
        int nums[][]={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        System.out.println(reconstructQueue(nums));
    }

    public static Boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (target < nums[0]) {
            int n = nums.length - 1;
            for (int i = n; i >= 0; --i) {
                if (nums[i] == target) {
                    return true;
                }
            }
            return false;
        } else if (target > nums[0]) {
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == target) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            if (isNum(tokens[i])) {
                numStack.push(Integer.valueOf(tokens[i]));
            } else {
                try {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    numStack.push(operate(num1, num2, tokens[i]));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return numStack.pop();
    }

    public static Boolean isNum(String target) {
        if (target.equals("*") || target.equals("/") || target.equals("+") || target.equals("-")) {
            return false;
        }
        return true;
    }

    public static int operate(int a, int b, String operator) {
        if (operator.equals("*")) {
            return a * b;
        }
        if (operator.equals("/")) {
            return b / a;
        }
        if (operator.equals("+")) {
            return a + b;
        }
        if (operator.equals("-")) {
            return b - a;
        }
        return 0;
    }

    public static Boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        int a, b, c;
        int i, j, k;
        int l = 1, m = 1, n = 1;
        i = 0;//a起始位置
        j = 1;
        k = 2;

        for (; j + m < num.length() && i < num.length() - 2; ) {
            a = Integer.valueOf(num.substring(i, i + l));
            b = Integer.valueOf(num.substring(j, j + m));
            for (; n + k <= num.length(); ) {
                c = Integer.valueOf(num.substring(k, k + n));
                if (a + b == c) {
                    i += l;
                    j += m;
                    k += n;
                    a = b;
                    b = c;
                    l = m;
                    m = n;
                    break;
                } else if (a + b > c) {
                    ++n;
                    if (n + k > num.length()) {
                        return false;
                    }
                    continue;
                } else {
                    if (m >= n) {
                        return false;
                    }
                    ++m;
                    break;
                }
            }

        }


        return true;
    }

    public static int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        int n = nums.length;
        if (n == 0)
            return 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum[nums[i]]++;
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max + 1];
        dp[0] = sum[0] * 0;
        dp[1] = sum[1] * 1;
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i] * i);
        }
        return dp[max];
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; ) {
                temp += nums[j];
                if (temp == k) {
                    count++;
                }
                j++;
            }
        }
        return count;
    }

    public static int numSubarraysWithSum(int[] A, int S) {
        int jk = 0;//1数组长度
        for (int x : A) {
            jk += x;
        }
        int[] indexes = new int[jk + 2];
        int t = 0;
        indexes[t++] = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                indexes[t++] = 1;
            }
        }
        indexes[t] = A.length;
        int count = 0;
        if (S == 0) {
            for (int i = 0; i < indexes.length - 1; i++) {
                int w = indexes[i + 1] - indexes[i] - 1;
                count += w * (w + 1) / 2;
            }
            return count;
        }
        for (int i = 1; i < indexes.length - S; ++i) {
            int j = i + S - 1;
            int left = indexes[i] - indexes[i - 1];
            int right = indexes[j + 1] - indexes[j];
            count += left * right;
        }

        return count;
    }

    /**
     * 阶乘
     *
     * @param num
     * @return
     */
    public static int recurrence(int num) {
        if (num <= 1)
            return 1;
        else
            return num * recurrence(num - 1);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int[] arr = new int[nums.length + 1];
        for (int i : nums) {
            arr[i]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                result.add(i);
            }
        }
        return result;
    }

    public static String originalDigits(String s) {
        //zero0 one1 two2 three3 four4 five5 six6 seven7 eight8 nine9
        List<Integer> result = new LinkedList();
        StringBuilder stringBuilder = new StringBuilder(s);
        Map<Character, Integer> number = new HashMap<>();
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (number.containsKey(stringBuilder.charAt(i))) {
                int temp = number.get(stringBuilder.charAt(i));
                number.put(stringBuilder.charAt(i), ++temp);
            } else {
                number.put(stringBuilder.charAt(i), 1);
            }
        }

        while (number.containsKey('z') && number.get('z') > 0) {
            result.add(0);
            deleteMap(number, 'z');
            deleteMap(number, 'e');
            deleteMap(number, 'r');
            deleteMap(number, 'o');
        }
        while (number.containsKey('w') && number.get('w') > 0) {
            result.add(2);
            deleteMap(number, 't');
            deleteMap(number, 'w');
            deleteMap(number, 'o');
        }
        while (number.containsKey('u') && number.get('u') > 0) {
            result.add(4);
            deleteMap(number, 'f');
            deleteMap(number, 'o');
            deleteMap(number, 'u');
            deleteMap(number, 'r');
        }
        while (number.containsKey('x') && number.get('x') > 0) {
            result.add(6);
            deleteMap(number, 's');
            deleteMap(number, 'i');
            deleteMap(number, 'x');
        }
        while (number.containsKey('g') && number.get('g') > 0) {
            result.add(8);
            deleteMap(number, 'e');
            deleteMap(number, 'i');
            deleteMap(number, 'g');
            deleteMap(number, 'h');
            deleteMap(number, 't');
        }

        while (number.containsKey('o') && number.get('o') > 0) {
            result.add(1);
            deleteMap(number, 'o');
            deleteMap(number, 'n');
            deleteMap(number, 'e');
        }
        while (number.containsKey('r') && number.get('r') > 0) {
            result.add(3);
            deleteMap(number, 't');
            deleteMap(number, 'h');
            deleteMap(number, 'r');
            deleteMap(number, 'e');
            deleteMap(number, 'e');
        }
        while (number.containsKey('f') && number.get('f') > 0) {
            result.add(5);
            deleteMap(number, 'f');
            deleteMap(number, 'i');
            deleteMap(number, 'v');
            deleteMap(number, 'e');
        }
        while (number.containsKey('s') && number.get('s') > 0) {
            result.add(7);
            deleteMap(number, 's');
            deleteMap(number, 'e');
            deleteMap(number, 'v');
            deleteMap(number, 'e');
            deleteMap(number, 'n');
        }
        while (number.containsKey('e') && number.get('e') > 0) {
            result.add(9);
            deleteMap(number, 'n');
            deleteMap(number, 'i');
            deleteMap(number, 'n');
            deleteMap(number, 'e');
        }

        result.sort((o1, o2) -> o1 - o2);
        StringBuilder stringResult = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            stringResult.append(result.get(i));
        }
        return stringResult.toString();
    }

    public static void deleteMap(Map<Character, Integer> map, char s) {
        int temp = map.get(s);
        map.put(s, --temp);
    }

    public static boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }

    public static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pushedStack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[j]) {
                j++;
                while (j < pushed.length && !pushedStack.isEmpty() && popped[j] == pushedStack.peek()) {
                    pushedStack.pop();
                    j++;
                }
            } else {
                pushedStack.push(pushed[i]);
            }
        }
        return j == pushed.length ? true : false;
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static String customSortString(String S, String T) {
        int[] charTimes = new int[27];
        for (int i = 0; i < T.length(); i++) {
            charTimes[T.charAt(i) - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            while (charTimes[S.charAt(i) - 'a'] > 0) {
                result.append(S.charAt(i));
                --charTimes[S.charAt(i) - 'a'];
            }
        }
        for (int i = 0; i < T.length(); i++) {
            while (charTimes[T.charAt(i) - 'a'] > 0) {
                result.append(T.charAt(i));
                --charTimes[T.charAt(i) - 'a'];
            }
        }
        return result.toString();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return func(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode func(int[] preorder, int[] inorder, int begin1, int end1, int begin2, int end2) {
        if (begin1 == preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[begin1]);
        if (begin1 == end1) {
            return root;
        }

        for (int index = end2; index >= begin2; index--) {
            if (preorder[begin1] == inorder[index]) {
                int length = index - begin2;
                root.left = func(preorder, inorder, begin1 + 1, begin1 + length, begin2, index - 1);
                root.right = func(preorder, inorder, begin1 + length + 1, end1, index + 1, end2);
                return root;
            }
        }
        return null;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> myStack = new Stack();

        while (root != null || !myStack.isEmpty()) {
            while (root != null) {
                myStack.push(root);
                root = root.left;
            }
            if (!myStack.empty()) {
                root = myStack.pop();
                result.add(root.val);
                root = root.right;
            }
        }


        return result;
    }

    public int singleNonDuplicate(int[] nums) {
//        int num=nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] ^ nums[i - 1];
        }
        return nums[nums.length - 1];
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Integer> leaves = new ArrayList<>();
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int t = adj.get(i).iterator().next();
                adj.get(t).remove(i);
                if (adj.get(t).size() == 1) newLeaves.add(t);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

    public static int addition(int num) {
        if (num == 0) return 0;
        return num + addition(num - 1);
    }

}
