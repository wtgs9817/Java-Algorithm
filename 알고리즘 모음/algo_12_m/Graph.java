package algo_12_m;

public class Graph {
	Node[] header;
	int n;
	
	Queue zeroPredQ = new Queue();  // �����ڰ� ���� �������� �����ϴ� ť (���������� ���� ����)
	Queue[] Q;	// ���� i�� �����ļ��ڸ� �����ϴ� ť
	int[] sortedList;   //���� ���� ����� �����ϴ� ����Ʈ
	int[] indegree; 	//������ ��������
		
	
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
			if(indegree[i] ==0) //�����ڰ� ������ {
				zeroPredQ.enqueue(i);
			}
		
		if(zeroPredQ.isEmpty()) {
			System.out.println("Network has a cycle");
		}
		
		while(!zeroPredQ.isEmpty()) {
			//indegree�� 0�� �������� ť���� �ϳ��� ������ ó��
			v = zeroPredQ.dequeue();
			
			sortedList[count] = v;
			count++;
			if(Q[v].isEmpty()) {
				continue;
				//���� v�� �ļ��ڰ� ������ ���� while ������
			}
			else {
				successor = Q[v].dequeue();
				//���� v�� �ļ��ڰ� ������, �� �ļ��ڸ� successor�� ����
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
