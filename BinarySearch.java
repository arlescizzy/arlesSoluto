/* *****************************************************************************
Just a normal binary search that I've been using; avoids integer overflow by
dividing the sum (lo + hi)/2 ===>>> lo + (hi - lo)/2
 **************************************************************************** */


public class BinarySearch {
    public static int returner(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
