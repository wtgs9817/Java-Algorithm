package algo_12_m;

public class SortMain {

	public static void main(String[] args) {
		
		
		//selection
		int[] a = {5,2,8,3,1};
		System.out.print("������ �迭 ���� :  "  );
		int i;
		
		for( i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		Sorting.selectionSort(a);
		System.out.print("���ĵ� �迭 ���� :  ");
		
		for(i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		
		
		System.out.println("=============================================================================================================================================================================");
		
		//buble
		
		int[] b = {5,2,11,8,3,1,7};
		System.out.print("������ �迭 ���� : ");
		
		for(i=0; i<b.length; i++) {
			System.out.print(b[i] + "  ");
		}
	
		System.out.println();
		Sorting.selectionSort(b);
		System.out.print("���ĵ� �迭 ���� :  ");
		for(i=0; i<b.length; i++) {
			System.out.print(b[i] + "   ");
		}
		
		System.out.println();
		
	
	}
}
