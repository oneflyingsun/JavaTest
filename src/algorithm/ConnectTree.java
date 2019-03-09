package algorithm;


/**
 * @Auther: ZhaoCong
 * @Date: 2018/11/8 15:50
 * @Description:
 */
public class ConnectTree {
    public static void main(String args[]) {


        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        //connect(root);
        System.out.println("test" + deleteNode(root, 2).val);

    }

    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }
        java.util.Queue treeNode = new java.util.concurrent.LinkedBlockingQueue();
        treeNode.add(root);

        while (!treeNode.isEmpty()) {
            TreeNode temp = (TreeNode) treeNode.poll();
            if (temp.left != null) {
                treeNode.add(temp.left);
                treeNode.add(temp.right);
            }
            if (treeNode.isEmpty()) {
                temp.next = null;
                break;
            }
            temp.next = (TreeNode) treeNode.element();
        }
        while (root != null) {
            root.next = null;
            root = root.right;
        }

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.val) {
            if (root.left == null || root.right == null) {
                root = root.left == null ? root.right : root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    //找到右分支的最小值
                    cur = cur.left;
                }
                root.val = cur.val;
                root.right = deleteNode(root.right, cur.val);
            }
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }


}
