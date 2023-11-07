package algo_10_m;

import java.util.*;

class Edge implements CompKey {
    int head;
    int weight;
    int tail;
    
    public Edge(int h, int t, int w) {
        head = h;
        tail = t;
        weight = w;
    }
  
    public int compareTo(Object value) {
        int a = this.weight;
        int b = ((Edge) value).weight;
        return a - b;
    }
}

