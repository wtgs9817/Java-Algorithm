package algo_09_m;

public class Graph {
	int n;
	int e;
	int [][] weight;

	public Graph(int noOfVertices) {

		n = noOfVertices;
		e = 0;
		weight = new int[n][n];

	}

	public void insertEdge(int i , int j) {
			weight[i][j] = 1;
			weight[j][i] = 1;
			e++;
		
		
	}

	public void removeEdge(int i , int j) {

		if(weight[i][j] ==1) {
		weight[i][j] = 0;
		weight[j][i] = 0;
		e--;
		}
		
	}
	
	public int[] adjacency(int u) {

		int[] adj;
		int deg = 0;
		int count = 0;
		
		for(int i=0; i<n; i++) {
			if(weight[u][i]==1) {
				count++;
			}
		}
		
		adj = new int[count];
		
		for(int i=0; i<n; i++) {
			if(weight[u][i] == 1) {
				adj[deg] = i;
				deg++;
			}
		}
		return adj;


	}

	

	public void bfs(int v) {

		Queue q = new Queue();
		boolean[] visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			visited[i] = false;
		}
		
		q.enqueue(v);
		visited[v] = true;

		System.out.println("BFS");
		while(!q.isEmpty()) {
			
			if(!q.isEmpty()) {
				v = q.dequeue();
				System.out.print(v + " ");
			}
			
			for(int i=0; i<n; i++) {
				if(weight[v][i] == 1) {
					if(visited[i]==false) {
						q.enqueue(i);
						visited[i] = true;
					}
				}
			}
			
			
			
		}
		

		

	}	

	

	public void dfs(int v) {
		Stack s = new Stack();
		boolean[] visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			visited[i] = false;
		}
		
		s.push(v);
		visited[v] = true;
		System.out.println("DFS");
		while(!s.isEmpty()) {
			
				v = s.pop();
				System.out.print(v + " ");
			
			
			for(int i=0; i<n; i++) {
			
				if(weight[v][i] ==1) {
					if(visited[i] == false) {
						s.push(i);
					visited[i] = true; 
				}
			}
			}

		}

	}
}
