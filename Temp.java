package p5_workspace;

class TreeNode {

	TreeList list;
	class static TreeList {
	    TreeNode head;
	    TreeNode tail;

	    public TreeList (TreeNode head, TreeNode tail) {
	        this.head = head;
	        this.tail = tail;
	    }
	}
}