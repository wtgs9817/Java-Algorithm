package algo_11_m;

public class Wgraph {
	int n;
	int e;
	int [][] weight;
	
	
	public Wgraph(int noOfVertices) {
		 n = noOfVertices;
		 e = 0;
		 weight = new int[n][n];
		 
		 
		 for(int i=0; i<n; i++) {
			 for(int k=0; k<n; k++) {
				 
				 if(i==k)  weight[i][k] = 0;
				 else weight[i][k] =9999; 
			 }
		 }
	}
	
	public Wgraph() {
		n = 0;
		e = 0;
	}
	
	public void insertEdge(int i , int j, int w) {
		weight[i][j] = w;
		e++;
	}
	
	public void removeEdge(int i , int j) {
		weight[i][j] = 9999;
		e--;
	}
	
	
	public int[] shortestPath(int v) {
		boolean s[] = new boolean[n];
		int dist[]  = new int[n];  // ������ v�κ��� dist[i]������ �ּҰ�
		int u=0;
		
		for(int i=0; i<n; i++) {
			s[i] = false;
			dist[i] = weight[v][i]; //dist�� �ʱ�ȭ
		}
		
		s[v] = true;
		dist[v] = 0;
		
		int min = Integer.MAX_VALUE;
		

		for(int i=0; i<n-2; i++) {  //n-1�ص� �� s�� true�� ���� false�̳� ���� dist���� �� �� ���� ��
			
			for(int j=0; j<n; j++) {
			if(!s[j] && dist[j] < min  ) {
				u =j;
				dist[u] = dist[j];
			}
		}				
			
			s[u] =true;
			
			for(int w=0; w<n; w++) {
				if(s[w] == false) {
					
					if(dist[w] > (dist[u] + weight[u][w])) {
						dist[w] = dist[u] + weight[u][w];
					}  
				}
			}
		}
		
		
		
		return dist;
		
	}
	
	
	public int[] negativePath(int v) {
		int dist[] = new int[n];
		int u;
		
		for(int i=0; i<n; i++) {
			dist[i] = weight[v][i];
		}
		
		for(int k=2; k<n-1; k++) {
			
			for(int j=0; j<n; j++) {
				
				for(int x=0; x<n; x++) {
					if(weight[j][x] != 9999) {
						if(dist[x] > dist[j] + weight[j][x]) {
							dist[x] = dist[j] + weight[j][x];
						}
					}
				}
			}
			
			
		}
		
		return dist;

	}
	
	public int[][] allShortestPath() {
		int[][] distance = weight;
		int[][] distanceP;
		int k , i , j;
		
		for(k=0; k<n; k++) {
			for(i=0; i<n; i++) {
				for(j=0; j<n; j++) {
					if(distance[i][j] > distance[i][k] + distance[k][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}
		return distance;
	}
	
}
