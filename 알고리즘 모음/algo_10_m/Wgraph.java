package algo_10_m;

public class Wgraph {

	int n;
	int e;
	int[][] weight;

	public Wgraph(int noOfVertices) {
		n =	noOfVertices;
		e = 0;
		weight = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(i==j) weight[i][j] = 0;
				else weight[i][j] = 9999;
			}
		}
	}
	
	public Wgraph() {
		n = 0;
		e = 0;
	}
	
	public void insertEdge(int i , int j , int w) {
		weight[i][j] = w;   //무방향 그래프
		weight[j][i] = w;
		e++;
	}
	
	public void removeEdge(int i , int j) {
		weight[i][j] = 9999;	 //무방향 그래프                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		weight[j][i] = 9999;   
		e--;
	}
	
	public Edge[] kruskal() {
		Edge[] T = new Edge[n-1];  //선택된 간선의 집합
		int Tptr = -1;  //간선 개수 확인
		
		MinHeap edgeList = new MinHeap();   //heap에 저장
		UnionFind uf = new UnionFind(n);	
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(weight[i][j]!=9999 && weight[i][j] !=0) {
					edgeList.insert(new Edge(i,j,weight[i][j]));
				}
			}
		}
		
		
		while(Tptr<n-1 && edgeList.numberElements()>0) {
			Edge e = (Edge) edgeList.delete();
			
			int u = e.head;
			int v = e.tail;
			
			if(uf.find(u, v) == false) {
				Tptr++;
				uf.union(u, v);
				T[Tptr] = e;
			}
		}
		
		return T;
		
		
	}
	
	public Edge[] prim(int i ) {
		Edge[] T = new Edge[n-1];  //선택된 간선의 집합
		int Tptr = -1;
		
		
		MinHeap edgeList = new MinHeap();
		UnionFind uf = new UnionFind(n);
		
		for(int k = 0; k<n; k++) {
			if(weight[i][k] != 9999 && weight[i][k] != 0) {
				edgeList.insert(new Edge(i,k,weight[i][k]));
			}
		}
		
		
		while(Tptr < n-2) {
			Edge e = (Edge) edgeList.delete();
			
			int u = e.head;
			int v = e.tail;
			
			if(uf.find(u, v) == false) {
				Tptr++;
				uf.union(u, v);
				T[Tptr] = e;
				
				for(int k = 0; k<n; k++) {
					if(weight[v][k] != 9999 && weight[v][k] != 0) {
						edgeList.insert(new Edge(v,k,weight[v][k]));
					}
				}
			}
	
		}
		
		return T;
		
	}
	
}
