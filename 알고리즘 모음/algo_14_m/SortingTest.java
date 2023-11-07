package algo_14_m;

public class SortingTest {

	public static void main(String[] args) {
		
		int[] test = {0,2,4,5,7,3,10,8,1,9,6};
		Sorting.heapSort(test);
		
		System.out.println();
		
		for(int i=0; i<test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}
}
