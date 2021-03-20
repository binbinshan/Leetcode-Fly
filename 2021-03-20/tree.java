//前序遍历
//时间复杂度O(n) 空间复杂度O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

}


//中序遍历
//时间复杂度O(n) 空间复杂度O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder(root.left, res);
        res.add(root.val);
        preorder(root.right, res);
    }
}


//后续遍历
//时间复杂度O(n) 空间复杂度O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder(root.left, res);
        preorder(root.right, res);
        res.add(root.val);
    }
}



//层级遍历
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //时间复杂度O(n) 空间复杂度O(root的高度)
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
			return new ArrayList<List<Integer>>();
		}
        //定义一个数组 返回结果数据
        List<List<Integer>> res = new ArrayList<>();
        //定义一个队列用于放每层的数据
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        //将根节点添加到队列中
        que.add(root);
        //如果队列长度大于0，就执行
        while(que.size()>0){
            //这里要单独获取队列开始的长度，因为后续会有元素出列，不能直接使用队列长度
            int size = que.size();
            //定义临时数组存储当前行数据
            List<Integer> tmp = new ArrayList<>();
            for(int i =0 ; i < size ;i++){
                TreeNode t = que.remove();
                tmp.add(t.val);

                if(t.left != null){
					que.add(t.left);
                }

                if(t.right != null){
					que.add(t.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}