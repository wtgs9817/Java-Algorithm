package algo_13_m;

public class Sorting {

	public static void quickSort(int[] a) {
		theQuickSort(a , 0 , a.length-1);
	}
	
	
	public static void theQuickSort(int[] a , int left , int right) {
		int p;
		if(left > right) return;
		
		p = partition(a ,left , right);
		theQuickSort(a , left , p-1);
		theQuickSort(a, p+1 , right);
	}
	
	
	private static int partition (int[] a , int i , int j) {
		int middle = (i+j)/2;  //middle은 a[]의 중앙 인덱스 값
		int pivot = a[middle]; // a[]의 중앙 원소값을 pivot으로 설정
		a[middle] = a[i];      // a[i]와 a[middle]을 서로 교환
		a[i] = pivot;		   // a[i]는 pivot 값을 보관
		int p = i;			   // p는 두 파티션의 경계를 지시하는 인덱스
		int temp;
		for(int k = i+1; k<=j; k++) {
			// a[i]를 제외한 a[i+1 : j]에 있는 모든 원소 a[k]들을 검사해서
			
			if(a[k] < pivot) {  //a[k]가 pivot보다 작으면
				p++;			// p를 증가시켜 a[k]를 p 인덱스 범위
				temp = a[p];	//안으로 포함되게 함
				a[p] = a[k];
				a[k] = temp;
				
			}
		}
		
		temp = a[i];
		a[i] = a[p];
		a[p] = temp;
		
		return p;
		
	}
	
	
	private static void swap(int[] a , int i , int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
	
	
	public static void mergeSort(int[] a ) {
		int[] temp = new int[a.length];
		theMergeSort(a, temp , 0 , a.length-1);
 	}
	
	private static void theMergeSort(int[] a , int[] temp , int left, int right) {
		if(left < right) {
			int middle = (left+right)/2;
			
			theMergeSort(a , temp , left , middle);
			theMergeSort(a , temp , middle+1 , right);
			merge(a , temp , left , middle , middle+1 , right);
		}
	}
	
	private static void merge(int[] a , int[] temp , int m , int p , int q , int n) {
		int t = m;
		int num = n-m+1;
		
		while(m <=p && q<=n) {
			if(a[m] < a[q]) {
				temp[t++] = a[m++];
			}
			else {
				temp[t++] = a[q++];
			}
		}
		
		while(m<=p)
			temp[t++] = a[m++];	  //
		
		while(q<= n)
			temp[t++] = a[q++];  //
		
		for(int i=0; i<num; i++,n--) {
			a[n] = temp[n];
		}
		
	}

}