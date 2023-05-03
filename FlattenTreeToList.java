
package p5_workspace;
//  Definition for a binary tree node.


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

class Solution {
    public void flatten(TreeNode root) {
        flattenToList(root);
    }


    class static TreeList {
        TreeNode head;
        TreeNode tail;

        public TreeList (TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    }

    private TreeList flattenToList (TreeNode root) {
        if(root.left == null && root.right == null) {
            return TreeList(root, root);
        }
        TreeList right = null, left = null;
        if(root.right != null){
             right = flattenToList(root.right);
        }
        if(root.left != null) {
            left = flattenToList(root.left);
        }
        if(right != null && left != null) {

            root.right = left.head;
            if(left.tail != null) {
                left.tail.right = right.head;
            } else {
                left.right = right.head;
            }
            return new TreeList(root, right.tail);
        } else if(left == null) {
            root.right = right.head;
            return new TreeList(root, right.tail);
        } else {
            root.right = left.head;
            return new TreeList(root, left.tail);
        }
    }
}