package algo_13_m;

public class Insert_Sorting {

	public static void insertionSort(int[] a ) {
		int ak,k,j;
		boolean move;
		
		for(int i=1; i<a.length; i++) {
			k = a[i];  //는 임시 저장소
			j = i;
			
			if(a[j-1] > k) {
				move = true;
			}
			else {
				move = false;
			}
			
			while(move) {
				a[j] = a[j-1];  //a[j-1]을 오른쪽으로 한자리 이동시켜 빈자리를 만듦
				j = j-1;
				
				if(j>0 && a[j-1]>k) {
					move = true;
				}
				else {
					move = false;
				}
			} //while
		
			a[j] = k;
		}
		
	}
	
	
}
