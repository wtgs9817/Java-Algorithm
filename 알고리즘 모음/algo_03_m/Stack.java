package algo_03_m;

public class Stack {
	private int top;
	private Object[] data;
	private final static int MAX =100;
	
	public Stack() {
		data = new Object[MAX];
		top = -1;
	}
	
	public int size() {
		return top + 1;
	}
	
	public boolean empty() {
		return (top == -1);
	}
	
	public void push(Object x) {
		top += 1;
		data[top] = x;
	}
	public Object pop() {
		top-=1;
		return data[top+1];
	}
	public Object peek() {
		return data[top];
	}
}
