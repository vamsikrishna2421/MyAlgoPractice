package main.java;

public class BinaryTree {
	private treeNode root;
	public BinaryTree() {
		this.root=null;
	}
	public class treeNode{
		private treeNode left;
		private treeNode right;
		private int data;
		public treeNode(int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	public void createBinaryTree() {
		treeNode first=new treeNode(1);
		treeNode second=new treeNode(2);
		treeNode third=new treeNode(3);
		treeNode fourth=new treeNode(4);
		treeNode fifth=new treeNode(5);
		
		root=first;
		first.left=second;
		first.right=third;
		second.left=fourth;
		second.right=fifth;
	}
	
	public void preOrder(treeNode root){
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(treeNode root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}

	public void postOrder(treeNode root){
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static void main(String []args) {
		BinaryTree tree=new BinaryTree();
		tree.createBinaryTree();
		System.out.println("\n Preorder:");
		tree.preOrder(tree.root);
		System.out.println("\n Inorder:");
		tree.inOrder(tree.root);
		System.out.println("\n Postorder:");
		tree.postOrder(tree.root);
	}
}
