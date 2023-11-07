package algo_14_m;

public class Sorting {

	public static void heapSort(int[] a ) {
		int n = a.length-1; //n ==> 히프 크기(원소의 수)
		
		for(int i=n/2; i>=1; i--) {
			heapify(a , i ,n);
		}
		
		for(int i=n-1; i>=1; i--) {
			int temp = a[1];
			a[1] = a[i+1];
			a[i+1] = temp;
			
			heapify(a,1,i);
		}
		
	}
	
	
	private static void heapify(int[] a , int h , int m ) {
		int ah = a[h];
		int j;
		for(j=2*h; j<=m; j=2*j) {
			if(j<m) {
				if(a[j] < a[j+1]) {
					j++;
				}
			}
			if(ah>=a[j]) {
				return;
			}
			else {
				a[j/2] = a[j];
			}
		}
		
		a[j/2] = ah;
		
	}
}
