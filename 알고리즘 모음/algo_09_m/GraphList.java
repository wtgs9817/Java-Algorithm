package algo_09_m;

public class GraphList {

	int n;
	int e;
	Node[] header;
	
	public GraphList(int noOfVertices) {
		n = noOfVertices;
		e = 0;
		header = new Node[n];
	}
	
	public void insertEdge(int i , int j) {
		Node newNode = new Node();
		Node newNode2 = new Node();
		newNode.vertex = i;
		newNode2.vertex = j;
		
		newNode.link = header[j];
		header[j] = newNode;
		
		newNode2.link = header[i];
		header[i] = newNode2;

	}
	
	public void removeEdge(int i , int j) {
		Node p = header[i];
		Node n;
		if(p != null) {
			
			while(p != null) {
				if(p.link.vertex == j) {
					n = p;
					p = p.link.link;
					
					n.link = p;
					return;
					
				}
				else {
					 p = p.link;
				}
				
			}
			
			p = header[j];
			while(p != null) {
				if(p.link.vertex == i) {
					n = p;
					p = p.link.link;
					
					n.link = p;
					return;	
				}
				else {
					 p = p.link;
				}	
			}
		}
		
	}
	
	public int[] adjacency(int u) {
		int[] adj;
		int deg = 0;
		int count =0;
		
		Node p = header[u];
		while(p != null) {
			
			p = p.link;
			count++;
		}
		
		adj = new int[count];
		
		Node n = header[u];
		while(n != null) {
			adj[deg] = n.vertex;
			deg++;
			n = n.link;
		}
		
		return adj;
		
	}
	
	public void bfs(int v) {
		Queue q = new Queue();
		boolean[] visited = new boolean[n];
		
		for(int i =0; i<n; i++) {
			visited[i] = false;
		}
		
		Node p = header[v];
		q.enqueue(v);
		visited[v] = true;
		System.out.print("BFS : ");
		
		while( !q.isEmpty()) {
			
			v = q.dequeue();
			System.out.print(v + "   ");
			
			Node t = header[v];
			
			while(t!= null) {
				
				if(visited[t.vertex] == false) {
					q.enqueue(t.vertex);
					visited[t.vertex] = true;
					t = t.link;
				}
				else {
					t = t.link;
				}
			}
		}

	}
	
	public void dfs(int v) {
	
		
		
		
		Stack s = new Stack();
		boolean[] visited = new boolean[n];
		
		
		for(int i =0; i<n; i++) {
			visited[i] = false;
		}
		
		Node p = header[v];
		s.push(v);
		visited[v] = true;
		System.out.print("DFS : ");
		
		while( !s.isEmpty()) {
			
			v = s.pop();
			System.out.print(v + "  ");
			
			Node t = header[v];
			
			while(t!= null) {
				
				if(visited[t.vertex] == false) {
					s.push(t.vertex);
					visited[t.vertex] = true;
					t = t.link;
				}
				else {
					t = t.link;
				}
			}
		}
	}
}
