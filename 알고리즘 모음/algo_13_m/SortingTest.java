package algo_13_m;

public class SortingTest {

	public static void main(String[] args) {
		
		int test[] = {3 , 1, 4, 5, 9 , 8, 7};
		Sorting.quickSort(test);
		
		for(int i=0; i< test.length; i++) {
			System.out.print(test[i] + " ");
		}
		
		System.out.println();
		
		int test2[] = {0,2,4,5,7,3,10,8,1,9,6};
		Sorting.mergeSort(test2);
		
		for(int i=0; i<test2.length; i++) {
			System.out.print(test2[i] + " ");
		}
		
	}
}
