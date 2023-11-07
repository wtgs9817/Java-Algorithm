package algo_12_m;

public class Graph {
	Node[] header;
	int n;
	
	Queue zeroPredQ = new Queue();  // 선행자가 없는 정점들을 저장하는 큐 (진입차수가 없는 정점)
	Queue[] Q;	// 정점 i의 직속후속자를 저장하는 큐
	int[] sortedList;   //위상 정렬 결과를 보관하는 리스트
	int[] indegree; 	//정점의 진입차수
		
	
	public Graph(int vertices) {
		n = vertices;
		header = new Node[n];
		Q = new Queue[n];
		 sortedList = new int[n]; 
		indegree = new int[n];
		for(int i=0; i<n; i++) {
			Q[i] = new Queue();
		}
		
	}
	
	public void insertEdge(int i , int j) {
		Q[i].enqueue(j);
		indegree[j]++;
	}
	
	
	public void topologicalSort() {
		int i , v , successor;
		int count=0;
	
		
		for(i=0; i<n; i++) {
			if(indegree[i] ==0) //선행자가 없으면 {
				zeroPredQ.enqueue(i);
			}
		
		if(zeroPredQ.isEmpty()) {
			System.out.println("Network has a cycle");
		}
		
		while(!zeroPredQ.isEmpty()) {
			//indegree가 0인 정점들을 큐에서 하나씩 삭제해 처리
			v = zeroPredQ.dequeue();
			
			sortedList[count] = v;
			count++;
			if(Q[v].isEmpty()) {
				continue;
				//정점 v의 후속자가 없으면 밖의 while 루프로
			}
			else {
				successor = Q[v].dequeue();
				//정점 v의 후속자가 있으면, 그 후속자를 successor로 설정
			}
			
			while(true) {
				indegree[successor]--;
				
				if(indegree[successor] == 0) {
					zeroPredQ.enqueue(successor);
				}
				if(!Q[v].isEmpty()) {
					successor = Q[v].dequeue();
				}
				else {
					break;
				}
			}

		}
		
		System.out.print("Topological Order is : ");
		for(i=0; i<n; i++) {
			System.out.print(sortedList[i] + " ");
		}
		
	}
	

	
}
