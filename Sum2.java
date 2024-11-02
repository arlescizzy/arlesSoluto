/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
// I'm using indexing from the last so that the numbers are in descending order.

public class Sum2 {

    public void sum3(int[] list, int key) {

        for (int k = list.length - 1; k >= 0; k--) {
            for (int j = k - 1; j >= 0; j--) {
                int y = key - list[j] - list[k];
                int x = BinarySearch.returner(y, list);
                if (x != -1 && x < j)
                    System.out.print("\n Your three numbers are: " + list[x] + ", " + list[j]
                                             + ",and " + list[k]);

            }
        }
    }


    public static void main(String[] args) {
        Sum2 x = new Sum2();
        x.sum3(Reader.readIntegers(), Reader.readKey("key"));
    }
}
