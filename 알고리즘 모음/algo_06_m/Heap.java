package algo_06_m;
import java.util.Arrays;


public class Heap {

	private int count;
    private int size;
    private int[] itemArray;
    
    public Heap() {
        count = 0;
        size = 64;
        itemArray = new int[size];
    }
    
    public Heap(int[] origArray) {
    	 size = origArray.length;
    	 count = size-1;
    	 itemArray = origArray;
    	 
    		for(int i=1; i<=count; i++) {
    			for(int j=i+1; j<=count; j++) {
    				if(itemArray[i] > itemArray[j]) { 
    					int temp = itemArray[i];
    					itemArray[i] = itemArray[j];
    					itemArray[j] = temp;
    				}
    			}
    		}
    	
    }
   
    public void insert(int newItem) {
    	int min;
    	int max;
    	
    	if(count==0) {
    		itemArray[count+1] = newItem;
    		count++;
    	}
    	
    	else {
    		itemArray[count+1] = newItem;
        	count++;
    	
        	for(int i=1; i<=count; i++) {
    			for(int j=i+1; j<=count; j++) {
    				if(itemArray[i] > itemArray[j]) { 
    					int temp = itemArray[i];
    					itemArray[i] = itemArray[j];
    					itemArray[j] = temp;
    				}
    			}
    		}
    	}
    	
    	
    	if(count == size) {
    	int[] temp = new int[size*2];
    	for(int i=0; i<count; i++) {
    		temp[i] = itemArray[i];
    	}
    	itemArray = temp;
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

    public int delete() {
    	int num = itemArray[1];
    	
    	for(int i=1; i<=count; i++) {
    		if(i!= count) {
    			itemArray[i] = itemArray[i+1];
    		}
    	}
    	
    	
    	
    	return num;
    	
    }

    public void printHeap() {
        int i;
        for (i = 1; i <=count; i++)
            System.out.print(itemArray[i] + " ");
        	System.out.println();
    }
}
