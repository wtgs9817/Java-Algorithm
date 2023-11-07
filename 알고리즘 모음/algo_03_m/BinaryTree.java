package algo_03_m;

public class BinaryTree {
BTNode root;
	
	public BinaryTree() {
		this.root = new BTNode(null, null , null);
	}
	
	public BinaryTree(BinaryTree ltree , String data , BinaryTree rtree) {
		this.root = new BTNode(ltree.root , data , rtree.root);
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
	
	public BinaryTree leftSubTree() {
		BinaryTree tr  = new BinaryTree();
		tr.root = this.root.Lchild;
		
		return tr;
	}
	
	public BinaryTree rightSubTree() {
		BinaryTree tr  = new BinaryTree();
		tr.root = this.root.Rchild;
		
		return tr;
		
	}
	public String rootdata() {
		return this.root.data;
	}
	
	public void inorder() {
		//중위
		theInorder(this.root);
	}
	public void preorder() {
		//전위
		thePreorder(this.root);
	}

	public void postorder() {
		//후위
		thePostorder(this.root);
	}
	
	private void theInorder(BTNode bt) {	 //중위
		if(bt != null) {
			theInorder(bt.Lchild);
			if(bt.data != null) {
				System.out.println(bt.data);
			}
			theInorder(bt.Rchild);
		}
	}

	private void thePreorder(BTNode bt) {  //전위
		if(bt != null) {
			if(bt.data != null) {
				System.out.println(bt.data);
			}
			thePreorder(bt.Lchild);
			thePreorder(bt.Rchild);
		}
	}

	private void thePostorder(BTNode bt) {  //후위
		if(bt != null) {
		thePostorder(bt.Lchild);
		thePostorder(bt.Rchild);
		if( bt.data != null) {
			System.out.println(bt.data);
		}
		}
		
    }
	
	private void inorderlter() {  //중위 스택
		Stack s = new Stack();
		BTNode p = root;
		
		while( p!=null || !s.empty()) {
			while(p != null) {
				s.push(p);
				p = p.Lchild;
			}
			p = (BTNode) s.pop();
			System.out.println(p.data);
			
			p = p.Rchild;
			
		}
	}
	
	private void preorderlter() {
		Stack s = new Stack();
		BTNode p = root;
		
		while( p!=null || !s.empty()) {
			while(p != null) {
				s.push(p);
				p = p.Lchild;
			}
			
			p = (BTNode) s.pop();
			if(p.data != null) {
			System.out.println(p.data);
			}
			p = p.Rchild;
			
		}
	}
	
	public void stackinorder() {
		this.preorderlter();
	}
	
	public void levelorder() {
		Queue q = new Queue();
		//BTNode node = root;
		q.enqueue(root);
		BTNode node;
		while(!q.isEmpty()) {
			node = (BTNode) q.dequeue();
			
			if(node!=null) {
				if(node.data != null) {
				System.out.println(node.data);
				}
				q.enqueue(node.Lchild);
				q.enqueue(node.Rchild);
			}
		}
		
	}
	
	public BinaryTree copy() {
		BinaryTree newtree  = new BinaryTree();
		newtree.root = thecopy(root);
		
		return newtree;
		
	}
	
	private BTNode thecopy(BTNode t) {
		BTNode s = null;
		
		if(t != null) {
		BTNode L = thecopy(t.Lchild);
		BTNode R = thecopy(t.Rchild);
		
		s = new BTNode(L,t.data,R);
		}
		
	return s;
	}
	
	public boolean equal(BinaryTree tr) {
		return theEqual(this.root , tr.root);
	}
	
	private boolean theEqual(BTNode s , BTNode t) {
		if(s ==null && t == null) return true;
		
		else if(s!=null && t!=null) {
			
			if(s.data != null && t.data != null) {
				
			
			if(s.data.equals(t.data)) {
				if(theEqual(s.Lchild , t.Lchild)) {
					return theEqual(s.Rchild , t.Rchild);
				}else {
					return false;
				}
			}
			
			else {
				return false;
			}
			
			}
			else {
				return false;
			}
		}
		
		else {
			return false;
		}
		
		
	}
}
