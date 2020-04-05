import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class PMergeSort extends Thread implements Runnable{
	
	
	static int val = 10000;  // Place the number of values here
								// Defining Main Arrays
	static int[] arr_test= new int[val];
	static int[] arr_test2= new int[val];
	static int[] arr_test4= new int[val];
	static int[] arr_test8= new int[val];
	
								// Defining Sub Arrays
	static int[] arr1 ,arr2= new int[val/2];
	static int[] arr41, arr42, arr43 , arr44= new int[val/4];
	static int[] arr81, arr82 , arr83 , arr84 ,arr85 , arr86 , arr87 , arr88 = new int[val/8];
	
		static Thread t21 = new Thread(){
			public void run(){
			System.out.println("Thread 1 is executing");
	    	mergeSort(arr1);
			}};
	
		static Thread t22 = new Thread(){
			public void run(){
				System.out.println("Thread 2 is executing");
				mergeSort(arr2);
			}};
	//************************************************
		static Thread t41 = new Thread(){
			public void run(){
				System.out.println("Thread 41 is executing");
				mergeSort(arr41);
			}};
		static Thread t42 = new Thread(){
			public void run(){
				System.out.println("Thread 42 is executing");
				mergeSort(arr42);
			}};
		static Thread t43 = new Thread(){
			public void run(){
				System.out.println("Thread 43 is executing");
				mergeSort(arr43);
			}};
		static Thread t44 = new Thread(){
			public void run(){
				System.out.println("Thread 44 is executing");
				mergeSort(arr44);
			}};
		//************************************************	
			
		static Thread t81 = new Thread(){
			public void run(){
				System.out.println("Thread 81 is executing");
				mergeSort(arr81);
			}};

		static Thread t82 = new Thread(){
			public void run(){
				System.out.println("Thread 82 is executing");
				mergeSort(arr82);
			}};
		static Thread t83 = new Thread(){
			public void run(){
				System.out.println("Thread 83 is executing");
				mergeSort(arr83);
			}};
		static Thread t84 = new Thread(){
			public void run(){
				System.out.println("Thread 84 is executing");
				mergeSort(arr84);
			}};
		static Thread t85 = new Thread(){
			public void run(){
				System.out.println("Thread 85 is executing");
				mergeSort(arr85);
			}};

		static Thread t86 = new Thread(){
			public void run(){
				System.out.println("Thread 86 is executing");
				mergeSort(arr86);
			}};
		static Thread t87 = new Thread(){
			public void run(){
				System.out.println("Thread 87 is executing");
				mergeSort(arr87);
			}};
		static Thread t88 = new Thread(){
			public void run(){
				System.out.println("Thread 88 is executing");
				mergeSort(arr88);
			}};
			
		//************************************************	
			
	public static void main(String[] args) throws IOException {
		
		
	    for (int i=0; i<val; i++){
    int n = (int)(Math.random()*val + 1);
    arr_test[i] = n;   
    arr_test2[i] = n;
    arr_test4[i] = n;
    arr_test8[i] = n;
}
	 // Measuring the timing for the eight thread execution
	    long start8 = System.currentTimeMillis(); // Get Time
	    int mid =  arr_test8.length/2;
	     arr81 =Arrays.copyOfRange(arr_test8, 0 , (mid/4));
	     arr82 =Arrays.copyOfRange(arr_test8, (mid/4), (mid/2) );
	     arr83 =Arrays.copyOfRange(arr_test8, (mid/2),mid-(mid/4) );
	     arr84 =Arrays.copyOfRange(arr_test8, mid-(mid/4) , mid);
	     arr85 =Arrays.copyOfRange(arr_test8, mid , mid+(mid/4));
	     arr86 =Arrays.copyOfRange(arr_test8, mid+(mid/4), val-(mid/2));
	     arr87 =Arrays.copyOfRange(arr_test8, val-(mid/2),val-(mid/4) );
	     arr88 =Arrays.copyOfRange(arr_test8, val-(mid/4), val );
	     
	     t81.start();
	     t82.start();
	     t83.start();
	     t84.start();
	     t85.start();
	     t86.start();
	     t87.start();
	     t88.start();
	     
	     while (Thread.activeCount() > 1) {
	     }
			int arr8s1[] = new int [val/4];
			int arr8s2[] = new int [val/4];
			int arr8s3[] = new int [val/4];
			int arr8s4[] = new int [val/4];
			int arr8sp1[] = new int [val/2]; //
			int arr8sp2[] = new int [val/2];
			int arr8final[] = new int [val]; //
			long mtest81 = System.currentTimeMillis();
			merge(arr8s1, arr81, arr82);
			merge(arr8s2, arr83, arr84);
			merge(arr8s3, arr85, arr86);
			merge(arr8s4, arr87, arr88);
			
			merge(arr8sp1, arr8s1, arr8s2);
			merge(arr8sp2, arr8s3, arr8s4);
			
			merge(arr8final, arr8sp1, arr8sp2);
			long mtest82 = System.currentTimeMillis();
			long rm8 = mtest82 - mtest81; 
			System.out.println("rm8 "+rm8);
			 long end8 = System.currentTimeMillis();
			long elapsed8 = end8 - start8; 
	    	System.out.println(elapsed8);
	    
	
	    
	 // Measuring the timing for the quadric thread execution
	    long start4 = System.currentTimeMillis(); // Get Time
	    mid =  arr_test.length/2;
	     arr41 =Arrays.copyOfRange(arr_test4, 0 , (mid/2) );
	     arr42 =Arrays.copyOfRange(arr_test4, (mid/2), mid );
	     arr43 =Arrays.copyOfRange(arr_test4, mid, (val - (mid/2)) );
	     arr44 =Arrays.copyOfRange(arr_test4, (val - (mid/2) ), val);
	     
	     t41.start();
	     t42.start();
	     t43.start();
	     t44.start();
	     
	     while (Thread.activeCount() > 1) {
	     }
			int arr5[] = new int [val/2];
			int arr6[] = new int [val/2];
			int arr7[] = new int [val];
			long mtest41 = System.currentTimeMillis();
			merge(arr5, arr41, arr42);
			merge(arr6, arr43, arr44);
			merge(arr7, arr5, arr6);
			long mtest42 = System.currentTimeMillis();
			long rm4 = mtest42 - mtest41; 
			 long end4 = System.currentTimeMillis();
			long elapsed4 = end4 - start4; 
	    	System.out.println(elapsed4);
	    
	    
	    // Measuring the timing for the double thread execution
	    long start1 = System.currentTimeMillis(); // Get Time   
	     mid =  arr_test.length/2;
	     arr1 =Arrays.copyOfRange(arr_test2, 0 , mid );
	     arr2 =Arrays.copyOfRange(arr_test2, mid, arr_test.length );
		
	     t21.start();
	     t22.start();
	     while (Thread.activeCount() > 1) {
	     }
			int arr3[] = new int [val];
			long mtest21 = System.currentTimeMillis();
			merge(arr3, arr1, arr2);
			long mtest22 = System.currentTimeMillis();
			long rm2 = mtest22 - mtest21; 
			 long end1 = System.currentTimeMillis();
			long elapsed1 = end1 - start1; 
	    	System.out.println(elapsed1);
	    	
			
	    	// Measuring single thread
	    	long start2 = System.currentTimeMillis(); // Get Time
	    	mergeSort(arr_test2);
	    	long end2 = System.currentTimeMillis();				   
			long elapsed2 = end2 - start2; 
				System.out.println(elapsed2);

		
	
	}
	
	 public static void mergeSort(int[] array) {
	        if (array.length > 1) {
	            // split array into two halves
	            int[] left = leftHalf(array);
	            int[] right = rightHalf(array);
	            
	            // recursively sort the two halves
	            mergeSort(left);
	            mergeSort(right);
	            
	            // merge the sorted halves into a sorted whole
	            merge(array, left, right);
	        }
	    }
	    
	    // Returns the first half of the given array.
	    public static int[] leftHalf(int[] array) {
	        int size1 = array.length / 2;
	        int[] left = new int[size1];
	        for (int i = 0; i < size1; i++) {
	            left[i] = array[i];
	        }
	        return left;
	    }
	    
	    // Returns the second half of the given array.
	    public static int[] rightHalf(int[] array) {
	        int size1 = array.length / 2;
	        int size2 = array.length - size1;
	        int[] right = new int[size2];
	        for (int i = 0; i < size2; i++) {
	            right[i] = array[i + size1];
	        }
	        return right;
	    }
	    
	    // Merges the given left and right arrays into the given 
	    // result array.  Second, working version.
	    // pre : result is empty; left/right are sorted
	    // post: result contains result of merging sorted lists;
	    public static void merge(int[] result, 
	                             int[] left, int[] right) {
	        int i1 = 0;   // index into left array
	        int i2 = 0;   // index into right array
	        
	        for (int i = 0; i < result.length; i++) {
	            if (i2 >= right.length || (i1 < left.length && 
	                    left[i1] <= right[i2])) {
	                result[i] = left[i1];    // take from left
	                i1++;
	            } else {
	                result[i] = right[i2];   // take from right
	                i2++;
	            }
	        }
	    }
	
	
}
