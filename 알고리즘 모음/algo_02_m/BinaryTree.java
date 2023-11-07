package algo_02_m;



public class BinaryTree {
BTNode root;
	
	public BinaryTree() {
		root = new BTNode(null , null , null);
	}
	
	public BinaryTree(BinaryTree ltree , String data , BinaryTree rtree) {
		root = new BTNode(ltree.root , data , rtree.root);
	}
	
	public boolean isEmpty() {
		
		if(root.Lchild != null) {
			return false;
		}
		
		else if(root.Rchild != null) {
			return false;
		}
		
		else {
			return true;
		}
		
	}
	
	public BinaryTree leftSubTree(BinaryTree tr) {
		BinaryTree tree =tr;

		
		if(tr == null) {
			return null;
		}
		else if(tr != null) {
			tree.root = tr.root.Lchild;	
		}
		return tree;
		
	}
	
	public BinaryTree rightSubTree(BinaryTree tr) {
		BinaryTree tree =tr;
	
		if(tr == null) {
			return null;
		}
		
		else if(tr != null) {
			tree.root = tr.root.Rchild;	
		}
		
		return tree;
		
	}
	
	public String rootData(BinaryTree tr) {
		return tr.root.data;
	}
	

	
	
	public void calculate() {
		BTNode bt = this.root;
		String curdata = root.data;
		
		int left = 0;
		int right = 0;
		int result = 0;
		
		
		
		//https://hanyeop.tistory.com/352
		
	}
	
	
	public double inOrder(BTNode root) {
		String curData = root.data;
		double left = 0;
		double right = 0;
		double result = 0;
		
		// left 결정 (마지막 레벨에 있는 숫자부터 연산)
		if(root.Lchild.Lchild == null) {
			left = Double.parseDouble(root.Lchild.data);
		}
		else {
			left = inOrder(root.Lchild);
		}
		
		// right 결정 (마지막 레벨에 있는 숫자부터 연산)
		if(root.Lchild.Lchild == null) {
			right = Double.parseDouble(root.Lchild.data);
		}
		else {
			right = inOrder(root.Lchild);
		}

		// 연산
		if(curData.equals("+")) {
			result = left + right;
		}
		else if(curData.equals("-")) {
			result = left - right;
		}
		else if(curData.equals("*")) {
			result = left * right;
		}
		else if(curData.equals("/")) {
			result = left / right;
		}
		return result;
	}
}
	
	

