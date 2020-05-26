public class MultiThreadedArrayAddition {



    public static void main(String[] args) {
        final int[] array1 = {0, 3, 2, 54, 6, 23, 56, 3, 5, 76, 32, 242, 67, 2, 4, 5, 9, 6, 3, 5, 78, 9};
        final int[] array2 = {0, 4, 3, 2, 54, 6, 9, 65, 43, 56, 3, 23, 56, 34, 87, 9, 34, 5, 231, 5, 4, 3};
        final int[] array3 = new int[22];
        int size1 = array1.length;
        int size2 = array2.length;

        assert size1 == size2;

        final int mid = size1 / 2;

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mid; i++) {
                    array3[i] = array1[i] + array2[i];
                }
            }
        }).start();

        for (int i = mid; i < array1.length; i++) {
            array3[i] = array1[i] + array2[i];
        }

        for (int i = 0; i < array1.length; i++) {
            System.out.print(array3[i] + "\t");
            System.out.print("\n");
        }

    }
}
