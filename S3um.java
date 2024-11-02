/* *****************************************************************************
I have made this one with n^2 complexity, better than n^2 log2(n) of my
previous solution using binary search. Avoids duplicates and the list is sorted
when fed to Reader.
 **************************************************************************** */

public class S3um {

    public void sum3(int[] list, int key) {
        for (int k = 0; k < list.length - 2; k++) {
            int j = k + 1;
            int x = list.length - 1;
            while (j < x) {
                int sum = list[j] + list[k] + list[x];
                if (sum < key) j++;
                else if (sum == key && k != j) {
                    System.out.print("\n The three numbers are: " + list[k] + ", "
                                             + list[j] + ",and " + list[x]);
                    j++;
                    x--;
                }
                else x--;
            }
            while (list[j] == list[j + 1]) j++;
            while (list[x] == list[x - 1]) x--;

        }
    }


    public static void main(String[] args) {
        S3um x = new S3um();
        x.sum3(Reader.readIntegers(), Reader.readKey("key"));
    }
}
