package algo_11_m;



public class Edge {
	int head;
	int tail;
	int weight;
	
	public Edge(int h , int t , int w) {
		head = h;
		tail = t;
		weight = w;
		
	}
	
	public int compareTo(Object value) {
		int a = this.weight;
	    int b = ((Edge)value).weight;
	    return a - b;
	}
}
