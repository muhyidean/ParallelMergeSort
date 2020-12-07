
import java.io.FileNotFoundException;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.concurrent.CountDownLatch;

public class PMergeSortCombinedComplete  {
    static int val = 1000;  // Place the number of values here
    static int numswitch = 0;



    public static void main(String[] args) throws IOException, InterruptedException {
        // The loop for the value
        for(int fl=0;fl<8;fl++){

            if(numswitch==0)
                numswitch = 1;
            else
                numswitch = 0;

            if(numswitch==1)
                val*=5;
            else
                val*=2;
            // Test partion caption
            try { PrintWriter outputfile = new PrintWriter(new FileWriter("./pmergeresultCOM.txt", true));
                outputfile.println("Test value: " + val);
                outputfile.close(); } catch (FileNotFoundException e) { e.printStackTrace(); }


            // Defining Main Arrays
            int[] arr_test = new int[val];
            int[] arr_test2 = new int[val];
            int[] arr_test4 = new int[val];
            int[] arr_test8 = new int[val];

            // Defining Sub Arrays
            int[] arr1 = new int[val / 2];
            int[] arr2 = new int[val / 2];
            int[] arr41 = new int[val / 4];
            int[] arr42 = new int[val / 4];
            int[] arr43 = new int[val / 4];
            int[] arr44 = new int[val / 4];
            int[] arr81 = new int[val / 8];
            int[] arr82 = new int[val / 8];
            int[] arr83 = new int[val / 8];
            int[] arr84 = new int[val / 8];
            int[] arr85 = new int[val / 8];
            int[] arr86 = new int[val / 8];
            int[] arr87 = new int[val / 8];
            int[] arr88 = new int[val / 8];


            for (int sl =0; sl < 10; sl++) {




                // 8 threads
                //Latch
                CountDownLatch latch8182 = new CountDownLatch(2);
                CountDownLatch latch8384 = new CountDownLatch(2);
                CountDownLatch latch8586 = new CountDownLatch(2);
                CountDownLatch latch8788 = new CountDownLatch(2);

                CountDownLatch latch81828384 = new CountDownLatch(2);
                CountDownLatch latch85868788 = new CountDownLatch(2);

                CountDownLatch latchFinal = new CountDownLatch(2);

                //Threads
                int[] finalArr815 = arr81;
                Thread t81 = new Thread(() -> {
                    mergeSort(finalArr815);
                    latch8182.countDown();
                });

                int[] finalArr814 = arr82;
                Thread t82 = new Thread(() -> {
                    mergeSort(finalArr814);
                    latch8182.countDown();
                });

                int[] finalArr813 = arr83;
                Thread t83 = new Thread(() -> {
                    mergeSort(finalArr813);
                    latch8384.countDown();
                });

                int[] finalArr812 = arr84;
                Thread t84 = new Thread(() -> {
                    mergeSort(finalArr812);
                    latch8384.countDown();
                });

                int[] finalArr811 = arr85;
                Thread t85 = new Thread(() -> {
                    mergeSort(finalArr811);
                    latch8586.countDown();
                });

                int[] finalArr810 = arr86;
                Thread t86 = new Thread(() -> {
                    mergeSort(finalArr810);
                    latch8586.countDown();
                });

                int[] finalArr89 = arr87;
                Thread t87 = new Thread(() -> {
                    mergeSort(finalArr89);
                    latch8788.countDown();
                });

                int[] finalArr88 = arr88;
                Thread t88 = new Thread(() -> {
                    mergeSort(finalArr88);
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
                int[] finalArr86 = arr81;
                int[] finalArr87 = arr82;
                Thread t8182 = new Thread(() -> {
                    try {
                        latch8182.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr8s1, finalArr86, finalArr87);
                    latch81828384.countDown();
                });

                int[] finalArr84 = arr83;
                int[] finalArr85 = arr84;
                Thread t8384 = new Thread(() -> {
                    try {
                        latch8384.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr8s2, finalArr84, finalArr85);
                    latch81828384.countDown();
                });

                int[] finalArr82 = arr85;
                int[] finalArr83 = arr86;
                Thread t8586 = new Thread(() -> {
                    try {
                        latch8586.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr8s3, finalArr82, finalArr83);
                    latch85868788.countDown();
                });

                int[] finalArr8 = arr87;
                int[] finalArr81 = arr88;
                Thread t8788 = new Thread(() -> {
                    try {
                        latch8788.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr8s4, finalArr8, finalArr81);
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
                long elapsed8 = end8 - start8;
                System.out.println("8 thread run time: " + (elapsed8));

                // 4 threads

                //Latch for 4 threads execution
                CountDownLatch latch4142 = new CountDownLatch(2);
                CountDownLatch latch4344 = new CountDownLatch(2);
                CountDownLatch latch41424344 = new CountDownLatch(2);

                // 4  Worker threads
                int[] finalArr47 = arr41;
                Thread t41 = new Thread(() -> {
                    mergeSort(finalArr47);
                    latch4142.countDown();
                });

                int[] finalArr46 = arr42;
                Thread t42 = new Thread(() -> {
                    mergeSort(finalArr46);
                    latch4142.countDown();
                });

                int[] finalArr45 = arr43;
                Thread t43 = new Thread(() -> {
                    mergeSort(finalArr45);
                    latch4344.countDown();
                });

                int[] finalArr44 = arr44;
                Thread t44 = new Thread(() -> {
                    mergeSort(finalArr44);
                    latch4344.countDown();
                });

                // Intermediate Result Arrays
                int arr5[] = new int[val / 2];
                int arr6[] = new int[val / 2];
                int arr7[] = new int[val];

                // Intermediate Threads for 4 thread execution.
                int[] finalArr42 = arr41;
                int[] finalArr43 = arr42;
                Thread t4142 = new Thread(() -> {
                    try {
                        latch4142.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr5, finalArr42, finalArr43);
                    latch41424344.countDown();
                });

                int[] finalArr4 = arr43;
                int[] finalArr41 = arr44;
                Thread t4344 = new Thread(() -> {
                    try {
                        latch4344.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr6, finalArr4, finalArr41);
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

                mid = arr_test8.length / 2;

                long start4 = System.currentTimeMillis(); // Get Time

                mid = arr_test.length / 2;
                arr41 = Arrays.copyOfRange(arr_test4, 0, (mid / 2));
                arr42 = Arrays.copyOfRange(arr_test4, (mid / 2), mid);
                arr43 = Arrays.copyOfRange(arr_test4, mid, (val - (mid / 2)));
                arr44 = Arrays.copyOfRange(arr_test4, (val - (mid / 2)), val);

                threads = new ArrayList<>();

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
                long elapsed4 = end4 - start4;
                System.out.println("4 thread run time: " + (elapsed4));

                // 2 threads

                int[] finalArr = arr1;
                Thread t21 = new Thread(() -> {
                    mergeSort(finalArr);
                });

                int[] finalArr1 = arr2;
                Thread t22 = new Thread(() -> {
                    mergeSort(finalArr1);
                });


                mid = arr_test.length / 2;
                arr1 = Arrays.copyOfRange(arr_test2, 0, mid);
                arr2 = Arrays.copyOfRange(arr_test2, mid, arr_test.length);
                long start1 = System.currentTimeMillis(); // Get Time

                t21.start();
                t22.start();
                while (Thread.activeCount() > 2) {
                }

                int arr3[] = new int[val];
                long mtest21 = System.currentTimeMillis();
                merge(arr3, arr1, arr2);
                long mtest22 = System.currentTimeMillis();
                long rm2 = mtest22 - mtest21;
                long end1 = System.currentTimeMillis();
                long elapsed1 = end1 - start1;
                System.out.println("2 thread run time: " + elapsed1);

                // Single Thread

                long start2 = System.currentTimeMillis(); // Get Time
                mergeSort(arr_test2);
                long end2 = System.currentTimeMillis();
                long elapsed2 = end2 - start2;
                System.out.println("Single thread run time: "+elapsed2);

                //==================
                try {
                    PrintWriter outputfile = new PrintWriter(new FileWriter("./pmergeresultCOM.txt", true));
                    outputfile.print(elapsed8 + "\t");
                    outputfile.print(elapsed4 + "\t");
                    outputfile.print(elapsed1 + "\t");
                    outputfile.println(elapsed2);
                    outputfile.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //=================



            }
        }

    }

    // The end of the loops are here
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
