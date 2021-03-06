import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class PMergeSort3 extends Thread implements Runnable {


    static int val = 5000000;  // Place the number of values here
    // Defining Main Arrays
    static int[] arr_test = new int[val];
    static int[] arr_test2 = new int[val];
    static int[] arr_test4 = new int[val];
    static int[] arr_test8 = new int[val];

    // Defining Sub Arrays
    static int[] arr1, arr2 = new int[val / 2];
    static int[] arr41, arr42, arr43, arr44 = new int[val / 4];
    static int[] arr81, arr82, arr83, arr84, arr85, arr86, arr87, arr88 = new int[val / 8];


    public static void main(String[] args) throws IOException, InterruptedException {

        //Latch
        CountDownLatch latch8182 = new CountDownLatch(2);
        CountDownLatch latch8384 = new CountDownLatch(2);
        CountDownLatch latch8586 = new CountDownLatch(2);
        CountDownLatch latch8788 = new CountDownLatch(2);

        CountDownLatch latch81828384 = new CountDownLatch(2);
        CountDownLatch latch85868788 = new CountDownLatch(2);

        CountDownLatch latchFinal = new CountDownLatch(2);

        //Threads
        Thread t81 = new Thread(() -> {
            mergeSort(arr81);
            latch8182.countDown();
        });

        Thread t82 = new Thread(() -> {
            mergeSort(arr82);
            latch8182.countDown();
        });

        Thread t83 = new Thread(() -> {
            mergeSort(arr83);
            latch8384.countDown();
        });

        Thread t84 = new Thread(() -> {
            mergeSort(arr84);
            latch8384.countDown();
        });

        Thread t85 = new Thread(() -> {
            mergeSort(arr85);
            latch8586.countDown();
        });

        Thread t86 = new Thread(() -> {
            mergeSort(arr86);
            latch8586.countDown();
        });

        Thread t87 = new Thread(() -> {
            mergeSort(arr87);
            latch8788.countDown();
        });

        Thread t88 = new Thread(() -> {
            mergeSort(arr88);
            latch8788.countDown();
        });

        // Intermediate Result Arrays
        int arr8s1[] = new int[val / 4];
        int arr8s2[] = new int[val / 4];
        int arr8s3[] = new int[val / 4];
        int arr8s4[] = new int[val / 4];
        int arr8sp1[] = new int[val / 2];
        int arr8sp2[] = new int[val / 2];
        int arr8final[] = new int[val];

        //Intermediate Threads for 8 thread execution.

        // 1st Level Merge
        Thread t8182 = new Thread(() -> {
            try {
                latch8182.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr8s1, arr81, arr82);
            latch81828384.countDown();
        });

        Thread t8384 = new Thread(() -> {
            try {
                latch8384.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr8s2, arr83, arr84);
            latch81828384.countDown();
        });

        Thread t8586 = new Thread(() -> {
            try {
                latch8586.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr8s3, arr85, arr86);
            latch85868788.countDown();
        });

        Thread t8788 = new Thread(() -> {
            try {
                latch8788.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr8s4, arr87, arr88);
            latch85868788.countDown();
        });


        // 2nd Level Merge
        Thread t81828384 = new Thread(() -> {
            try {
                latch81828384.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr8sp1, arr8s1, arr8s2);
            latchFinal.countDown();
        });

        Thread t85868788 = new Thread(() -> {
            try {
                latch85868788.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr8sp2, arr8s3, arr8s4);
            latchFinal.countDown();
        });

        //Final Merge
        Thread finalMerge = new Thread(() -> {
            try {
                latchFinal.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr8final, arr8sp1, arr8sp2);
        });




        for (int i = 0; i < val; i++) {
            int n = (int) (Math.random() * val + 1);
            arr_test[i] = n;
            arr_test2[i] = n;
            arr_test4[i] = n;
            arr_test8[i] = n;
        }

        int mid = arr_test8.length / 2;

        long start8 = System.currentTimeMillis(); // Get Time

        arr81 = Arrays.copyOfRange(arr_test8, 0, (mid / 4));
        arr82 = Arrays.copyOfRange(arr_test8, (mid / 4), (mid / 2));
        arr83 = Arrays.copyOfRange(arr_test8, (mid / 2), mid - (mid / 4));
        arr84 = Arrays.copyOfRange(arr_test8, mid - (mid / 4), mid);
        arr85 = Arrays.copyOfRange(arr_test8, mid, mid + (mid / 4));
        arr86 = Arrays.copyOfRange(arr_test8, mid + (mid / 4), val - (mid / 2));
        arr87 = Arrays.copyOfRange(arr_test8, val - (mid / 2), val - (mid / 4));
        arr88 = Arrays.copyOfRange(arr_test8, val - (mid / 4), val);

        List<Thread> threads = new ArrayList<>();

        t81.start();
        threads.add(t81);

        t82.start();
        threads.add(t82);

        t83.start();
        threads.add(t83);

        t84.start();
        threads.add(t84);

        t85.start();
        threads.add(t85);

        t86.start();
        threads.add(t86);

        t87.start();
        threads.add(t87);

        t88.start();
        threads.add(t88);


        t8182.start();
        threads.add(t8182);

        t8384.start();
        threads.add(t8384);

        t8586.start();
        threads.add(t8586);

        t8788.start();
        threads.add(t8788);


        t81828384.start();
        threads.add(t81828384);

        t85868788.start();
        threads.add(t85868788);


        finalMerge.start();
        threads.add(finalMerge);

        for (Thread t : threads) {
            t.join();
        }

        long end8 = System.currentTimeMillis();
        System.out.println(end8-start8);


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