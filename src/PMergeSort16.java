import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class PMergeSort16 {


/*

    static String currentDirectory = System.getProperty("user.dir");
        //System.out.println(currentDirectory);
        static BufferedReader brTest;

    static {
        try {
            brTest = new BufferedReader(new FileReader(currentDirectory + "\\src\\nums.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String num;

    static {
        try {
            num = brTest.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/


    static int val = 1000000;

        static int[] arr_test16 = new int[val];

        static int[] arr16_1, arr16_2, arr16_3, arr16_4, arr16_5, arr16_6, arr16_7, arr16_8,
                arr16_9, arr16_10, arr16_11, arr16_12, arr16_13, arr16_14, arr16_15, arr16_16 = new int[val / 16];

    public PMergeSort16() throws IOException {
    }


    public static void main(String[] args) throws InterruptedException, IOException {

       /*// To delete a row everytime it executes

        File path = new File(currentDirectory + "\\src\\nums.txt");
        Scanner scanner = new Scanner(path);
        ArrayList<String> coll = new ArrayList<String>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            coll.add(line);
        }

        scanner.close();

        FileWriter writer = new FileWriter(path);
        for (String line : coll) {
            writer.write(line + "\n");
        }

        writer.close();*/

            // Test partion caption
            try {
                PrintWriter outputfile = new PrintWriter(new FileWriter("./pmergeresult16.txt", true));
                outputfile.println("Test value: " + val);
                outputfile.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            for (int sl = 0; sl < 10; sl++) {

                // 1 Latch
                CountDownLatch latch12_1_12_2 = new CountDownLatch(2);
                CountDownLatch latch12_3_12_4 = new CountDownLatch(2);

                CountDownLatch latch12_5_12_6 = new CountDownLatch(2);
                CountDownLatch latch12_7_12_8 = new CountDownLatch(2);

                CountDownLatch latch12_9_12_10 = new CountDownLatch(2);
                CountDownLatch latch12_11_12_12 = new CountDownLatch(2);

                CountDownLatch latch12_13_12_14 = new CountDownLatch(2);
                CountDownLatch latch12_15_12_16 = new CountDownLatch(2);

                // 2 Latch
                CountDownLatch latch12_1_12_2_12_3_12_4 = new CountDownLatch(2);
                CountDownLatch latch12_5_12_6_12_7_12_8 = new CountDownLatch(2);

                CountDownLatch latch12_9_12_10_12_11_12_12 = new CountDownLatch(2);
                CountDownLatch latch12_13_12_14_12_15_12_16 = new CountDownLatch(2);

                // 3 Latch
                CountDownLatch latch12_1_12_2_12_3_12_4_12_5_12_6_12_7_12_8 = new CountDownLatch(2);
                CountDownLatch latch12_9_12_10_12_11_12_12_12_13_12_14_12_15_12_16 = new CountDownLatch(2);

                // Final
                CountDownLatch finalLatch = new CountDownLatch(2);


                //Threads
                Thread t16_1 = new Thread(() -> {
                    mergeSort(arr16_1);
                    latch12_1_12_2.countDown();
                });

                Thread t16_2 = new Thread(() -> {
                    mergeSort(arr16_2);
                    latch12_1_12_2.countDown();
                });
                //
                Thread t16_3 = new Thread(() -> {
                    mergeSort(arr16_3);
                    latch12_3_12_4.countDown();
                });

                Thread t16_4 = new Thread(() -> {
                    mergeSort(arr16_4);
                    latch12_3_12_4.countDown();
                });
                //
                Thread t16_5 = new Thread(() -> {
                    mergeSort(arr16_5);
                    latch12_5_12_6.countDown();
                });

                Thread t16_6 = new Thread(() -> {
                    mergeSort(arr16_6);
                    latch12_5_12_6.countDown();
                });
                //
                Thread t16_7 = new Thread(() -> {
                    mergeSort(arr16_7);
                    latch12_7_12_8.countDown();
                });

                Thread t16_8 = new Thread(() -> {
                    mergeSort(arr16_8);
                    latch12_7_12_8.countDown();
                });
                //
                Thread t16_9 = new Thread(() -> {
                    mergeSort(arr16_9);
                    latch12_9_12_10.countDown();
                });

                Thread t16_10 = new Thread(() -> {
                    mergeSort(arr16_10);
                    latch12_9_12_10.countDown();
                });
                //
                Thread t16_11 = new Thread(() -> {
                    mergeSort(arr16_11);
                    latch12_11_12_12.countDown();
                });

                Thread t16_12 = new Thread(() -> {
                    mergeSort(arr16_12);
                    latch12_11_12_12.countDown();
                });
                //
                Thread t16_13 = new Thread(() -> {
                    mergeSort(arr16_13);
                    latch12_13_12_14.countDown();
                });

                Thread t16_14 = new Thread(() -> {
                    mergeSort(arr16_14);
                    latch12_13_12_14.countDown();
                });
                //
                Thread t16_15 = new Thread(() -> {
                    mergeSort(arr16_15);
                    latch12_15_12_16.countDown();
                });

                Thread t16_16 = new Thread(() -> {
                    mergeSort(arr16_16);
                    latch12_15_12_16.countDown();
                });

                int arr12s1[] = new int[val / 8];
                int arr12s2[] = new int[val / 8];
                int arr12s3[] = new int[val / 8];
                int arr12s4[] = new int[val / 8];
                int arr12s5[] = new int[val / 8];
                int arr12s6[] = new int[val / 8];
                int arr12s7[] = new int[val / 8];
                int arr12s8[] = new int[val / 8];

                int arr12s1s2[] = new int[val / 4];
                int arr12s3s4[] = new int[val / 4];
                int arr12s5s6[] = new int[val / 4];
                int arr12s7s8[] = new int[val / 4];

                int arr12s1s2_s3s4[] = new int[val / 2];
                int arr12s5s6_s7s8[] = new int[val / 2];

                int arr12_final[] = new int[val];


                //Intermediate Threads for 16 thread execution.

                // 1st Level Merge

                Thread t121_122 = new Thread(() -> {
                    try {
                        latch12_1_12_2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s1, arr16_1, arr16_2);
                    latch12_1_12_2_12_3_12_4.countDown();
                });

                Thread t123_124 = new Thread(() -> {
                    try {
                        latch12_3_12_4.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s2, arr16_3, arr16_4);
                    latch12_1_12_2_12_3_12_4.countDown();
                });

                //

                Thread t125_126 = new Thread(() -> {
                    try {
                        latch12_5_12_6.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s3, arr16_5, arr16_6);
                    latch12_5_12_6_12_7_12_8.countDown();
                });

                Thread t127_128 = new Thread(() -> {
                    try {
                        latch12_7_12_8.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s4, arr16_7, arr16_8);
                    latch12_5_12_6_12_7_12_8.countDown();
                });

                //

                Thread t129_1210 = new Thread(() -> {
                    try {
                        latch12_9_12_10.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s5, arr16_9, arr16_10);
                    latch12_9_12_10_12_11_12_12.countDown();
                });

                Thread t1211_1212 = new Thread(() -> {
                    try {
                        latch12_11_12_12.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s6, arr16_11, arr16_12);
                    latch12_9_12_10_12_11_12_12.countDown();
                });

                //

                Thread t1213_1214 = new Thread(() -> {
                    try {
                        latch12_13_12_14.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s7, arr16_13, arr16_14);
                    latch12_13_12_14_12_15_12_16.countDown();
                });

                Thread t1215_1216 = new Thread(() -> {
                    try {
                        latch12_15_12_16.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s8, arr16_15, arr16_16);
                    latch12_13_12_14_12_15_12_16.countDown();
                });

                // 2 level merge

                Thread t121_122_3_4 = new Thread(() -> {
                    try {
                        latch12_1_12_2_12_3_12_4.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s1s2, arr12s1, arr12s2);
                    latch12_1_12_2_12_3_12_4_12_5_12_6_12_7_12_8.countDown();
                });

                Thread t125_126_7_8 = new Thread(() -> {
                    try {
                        latch12_5_12_6_12_7_12_8.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s3s4, arr12s3, arr12s4);
                    latch12_1_12_2_12_3_12_4_12_5_12_6_12_7_12_8.countDown();
                });

                Thread t129_1210_11_12 = new Thread(() -> {
                    try {
                        latch12_9_12_10_12_11_12_12.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s5s6, arr12s5, arr12s6);
                    latch12_9_12_10_12_11_12_12_12_13_12_14_12_15_12_16.countDown();
                });

                Thread t1213_1214_15_16 = new Thread(() -> {
                    try {
                        latch12_13_12_14_12_15_12_16.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s7s8, arr12s7, arr12s8);
                    latch12_9_12_10_12_11_12_12_12_13_12_14_12_15_12_16.countDown();
                });

                // 3 level merge

                Thread t31 = new Thread(() -> {
                    try {
                        latch12_1_12_2_12_3_12_4_12_5_12_6_12_7_12_8.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s1s2_s3s4, arr12s1s2, arr12s3s4);
                    finalLatch.countDown();
                });

                Thread t32 = new Thread(() -> {
                    try {
                        latch12_9_12_10_12_11_12_12_12_13_12_14_12_15_12_16.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12s5s6_s7s8, arr12s5s6, arr12s7s8);
                    finalLatch.countDown();
                });

                Thread t_final = new Thread(() -> {
                    try {
                        finalLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    merge(arr12_final, arr12s1s2_s3s4, arr12s5s6_s7s8);
                    finalLatch.countDown();
                });


                //execution

                for (int i = 0; i < val; i++) {
                    int n = (int) (Math.random() * val + 1);
                    arr_test16[i] = n;
                }

                int mid = arr_test16.length / 2;
                int q = mid / 2;
                int h = q / 2;
                int f = h / 2;


//TODO CAN YOU FIX THAT PART? IT IS CONFUSING FOR ME
//TODO FROM HERE

                arr16_1 = Arrays.copyOfRange(arr_test16, 0, f);
                arr16_2 = Arrays.copyOfRange(arr_test16, f, h);
                arr16_3 = Arrays.copyOfRange(arr_test16, h, h + f);
                arr16_4 = Arrays.copyOfRange(arr_test16, h + f, q);
                arr16_5 = Arrays.copyOfRange(arr_test16, q, q + f);
                arr16_6 = Arrays.copyOfRange(arr_test16, q + f, q + h);
                arr16_7 = Arrays.copyOfRange(arr_test16, q + h, q + h + f);
                arr16_8 = Arrays.copyOfRange(arr_test16, q + h + f, mid);
                arr16_9 = Arrays.copyOfRange(arr_test16, mid, mid + f);
                arr16_10 = Arrays.copyOfRange(arr_test16, mid + f, mid + h);
                arr16_11 = Arrays.copyOfRange(arr_test16, mid + h, mid + h + f);
                arr16_12 = Arrays.copyOfRange(arr_test16, mid + h + f, mid + q);
                arr16_13 = Arrays.copyOfRange(arr_test16, mid + q, mid + q + f);
                arr16_14 = Arrays.copyOfRange(arr_test16, mid + q + f, mid + q + h);
                arr16_15 = Arrays.copyOfRange(arr_test16, mid + q + h, mid + q + h + f);
                arr16_16 = Arrays.copyOfRange(arr_test16, mid + q + h + f, mid + mid);

                //TODO TO HERE

                long start16 = System.currentTimeMillis(); // Get Time

                List<Thread> threads = new ArrayList<>();

                t16_1.start();
                threads.add(t16_1);

                t16_2.start();
                threads.add(t16_2);

                t16_3.start();
                threads.add(t16_3);

                t16_4.start();
                threads.add(t16_4);

                t16_5.start();
                threads.add(t16_5);

                t16_6.start();
                threads.add(t16_6);

                t16_7.start();
                threads.add(t16_7);

                t16_8.start();
                threads.add(t16_8);

                t16_9.start();
                threads.add(t16_9);

                t16_10.start();
                threads.add(t16_10);

                t16_11.start();
                threads.add(t16_11);

                t16_12.start();
                threads.add(t16_12);

                t16_13.start();
                threads.add(t16_13);

                t16_14.start();
                threads.add(t16_14);

                t16_15.start();
                threads.add(t16_15);

                t16_16.start();
                threads.add(t16_16);


                t121_122.start();
                threads.add(t121_122);

                t123_124.start();
                threads.add(t123_124);

                t125_126.start();
                threads.add(t125_126);

                t127_128.start();
                threads.add(t127_128);

                t129_1210.start();
                threads.add(t129_1210);

                t1211_1212.start();
                threads.add(t1211_1212);

                t1213_1214.start();
                threads.add(t1213_1214);

                t1215_1216.start();
                threads.add(t1215_1216);

                t121_122_3_4.start();
                threads.add(t121_122_3_4);

                t125_126_7_8.start();
                threads.add(t125_126_7_8);

                t129_1210_11_12.start();
                threads.add(t129_1210_11_12);

                t1213_1214_15_16.start();
                threads.add(t1213_1214_15_16);

                t31.start();
                threads.add(t31);

                t32.start();
                threads.add(t32);

                t_final.start();
                threads.add(t_final);

                for (Thread t : threads) {
                    t.join();
                }

                long end16 = System.currentTimeMillis();
                long elapsed16 = end16 - start16;
                System.out.println("16 thread run time: " + (elapsed16));



            try {
                PrintWriter outputfile = new PrintWriter(new FileWriter("./pmergeresult16.txt", true));
                outputfile.println(elapsed16);
                outputfile.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //=================
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
