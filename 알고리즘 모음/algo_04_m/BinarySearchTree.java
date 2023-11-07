package algo_04_m;

public class BinarySearchTree {
	private TreeNode rootNode;
	
	public TreeNode BSTsearch(String k) {
		TreeNode p = rootNode;
		while(p != null) {
			if(p.key.compareTo(k)>0) {
				p = p.Lchild;
			}
			else if(p.key.compareTo(k)<0 ) {
				p = p.Rchild;
			}
			else {
				return p;
			}
		}
		return null; //탐색실패

	}
		
	
	public void BSTinsert(String k) {
		TreeNode p = this.rootNode;

		if( this.rootNode== null ) {
			this.rootNode = new TreeNode(k);

		}
		while(p != null) {
			if(p.key == k) {
				return;
			}
			else if(p.key.compareTo(k)>0) {
					if(p.Lchild == null) {
						p.Lchild = new TreeNode(k);
					}
					else {
						p = p.Lchild;
					}
			}

			else if(p.key.compareTo(k)<0) {
				if(p.Rchild == null) {
					p.Rchild = new TreeNode(k);
				}
				else {
					p = p.Rchild;
				}
			}	
		}
	}

 

	
	private TreeNode delete(TreeNode root , String k) {
		TreeNode p = root;
		TreeNode parent=null;
		

		while(p != null && p.key != k) {
			parent = p;
			if(p.key.compareTo(k)>0) {
				p = p.Lchild;
			}
			else if(p.key.compareTo(k)<0) {
				p = p.Rchild;
			}
		}
		
		if( p == null) {
			return null;
		}
		
		//리프노드
		if(p.Lchild == null &&  p.Rchild == null) {
			if(p != this.rootNode) {
				if(parent.Lchild ==p) {
					parent.Lchild =null;
				}
				else {
					parent.Rchild = null;
				}
			}
			else {
				this.rootNode = null;
			}
		}
		//한개일 때

		else if(p.Lchild != null && p.Rchild != null) {
			TreeNode temp = maxNode(p.Lchild);
			String tempval = temp.key;
			
			delete(root , temp.key);
			p.key = tempval;
		}
	
		else {
			TreeNode child = (p.Lchild != null) ? p.Lchild : p.Rchild;
			
			if(p != root) {
				if(parent.Lchild == p) {
					parent.Lchild = child;
				}
				else {
					parent.Rchild = child;
				}
			}
			else {
				root = child;
			}
		}
		return p;
	}

	public void BSTdelete(String k) {
		delete(this.rootNode, k);
	}

	
	private TreeNode maxNode(TreeNode root) {
		if(root.Rchild != null) {
			root = maxNode(root.Rchild);
		}
		return root;
	}
	
	private void printNode(TreeNode n) {
		if(n != null) {
			System.out.print("(");
			printNode(n.Lchild);
			
			
			System.out.print( n.key + " " );
			
			
			printNode(n.Rchild);
			System.out.print(")");
			

		}

	}

	

	public void print() {
		printNode(this.rootNode);
	}
	
	

}
