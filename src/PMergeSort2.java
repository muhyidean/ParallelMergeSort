import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class PMergeSort2 extends Thread implements Runnable {


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

        //Latch for 4 threads execution
        CountDownLatch latch4142 = new CountDownLatch(2);
        CountDownLatch latch4344 = new CountDownLatch(2);
        CountDownLatch latch41424344 = new CountDownLatch(2);

        // 4  Worker threads
        Thread t41 = new Thread(() -> {
            mergeSort(arr41);
            latch4142.countDown();
        });

        Thread t42 = new Thread(() -> {
            mergeSort(arr42);
            latch4142.countDown();
        });

        Thread t43 = new Thread(() -> {
            mergeSort(arr43);
            latch4344.countDown();
        });

        Thread t44 = new Thread(() -> {
            mergeSort(arr44);
            latch4344.countDown();
        });

        // Intermediate Result Arrays
        int arr5[] = new int[val / 2];
        int arr6[] = new int[val / 2];
        int arr7[] = new int[val];

        // Intermediate Threads for 4 thread execution.
        Thread t4142 = new Thread(() -> {
            try {
                latch4142.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr5, arr41, arr42);
            latch41424344.countDown();
        });

        Thread t4344 = new Thread(() -> {
            try {
                latch4344.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr6, arr43, arr44);
            latch41424344.countDown();
        });

        Thread t41424344 = new Thread(() -> {
            try {
                latch41424344.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(arr7, arr5, arr6);
        });


        //************************************************


        for (int i = 0; i < val; i++) {
            int n = (int) (Math.random() * val + 1);
            arr_test[i] = n;
            arr_test2[i] = n;
            arr_test4[i] = n;
            arr_test8[i] = n;
        }

        int mid = arr_test8.length / 2;

        long start4 = System.currentTimeMillis(); // Get Time

        mid = arr_test.length / 2;
        arr41 = Arrays.copyOfRange(arr_test4, 0, (mid / 2));
        arr42 = Arrays.copyOfRange(arr_test4, (mid / 2), mid);
        arr43 = Arrays.copyOfRange(arr_test4, mid, (val - (mid / 2)));
        arr44 = Arrays.copyOfRange(arr_test4, (val - (mid / 2)), val);

        List<Thread> threads = new ArrayList<>();

        t41.start();
        threads.add(t41);

        t42.start();
        threads.add(t42);

        t43.start();
        threads.add(t43);

        t44.start();
        threads.add(t44);

        t4142.start();
        threads.add(t4142);

        t4344.start();
        threads.add(t4344);

        t41424344.start();
        threads.add(t41424344);

        for (Thread t : threads) {
            t.join();
        }

        long end4 = System.currentTimeMillis();
        System.out.println(end4-start4);

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