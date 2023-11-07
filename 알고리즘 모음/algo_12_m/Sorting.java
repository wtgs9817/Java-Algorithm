package algo_12_m;

public class Sorting {
	
	public static void selectionSort(int[] a) {
		int i , k , min;
		
		for(i=0; i<a.length; i++) {
			
			for(k =i+1, min =i; k<a.length; k++) {
				if(a[k] < a[min] ) {
					min = k;
				}
			}
			swap(a , min , i);
			
		}
	}
	
	public static void swap(int[] a , int k , int i) {
		int temp = a[k];
		a[k] = a[i];
		a[i] = temp;
		
	}

	public static void bubbleSort(int[] a) {
		int i,j;
		
		for(i = a.length-1; i>=0; --i) {
			for(j=0; j<i; j++) {
				if(a[j] > a[j+1])
					swap(a , j , j+1);
			}
		}
		
		
		
		
		
	}

}
