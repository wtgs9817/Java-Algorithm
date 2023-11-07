package algo_03_m;

public class BTNode {
	String data;
	 BTNode Lchild;
	BTNode Rchild;
	
	public BTNode() {
		data= null;
		Lchild=null;
		Rchild=null;
	}
	
	public BTNode(String data) {
		this.data= data;
		Lchild=null;
		Rchild=null;
	}
	
	public BTNode(BTNode lc ,String data, BTNode rc) {
		this.data = data;
		Lchild = lc;
		Rchild = rc;
	}
}
