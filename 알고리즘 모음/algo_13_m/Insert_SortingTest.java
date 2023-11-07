package algo_13_m;

public class Insert_SortingTest {

	public static void main(String[] args) {
		//int test[] = {6,7,8};
		
		int test[]  = {6, 1 , 7 , 8 , 5 , 3 ,2 };
		
		Insert_Sorting.insertionSort(test);
		
		for(int i=0; i<7; i++) {
			System.out.print(test[i] +  "  ");
		}
	}
}
